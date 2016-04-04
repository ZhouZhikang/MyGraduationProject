/**
 * Created by Administrator on 15-9-18.
 */
function getStyle(obj,attr){
    if(obj.currentStyle)
         return obj.currentStyle[attr];
    else
    return getComputedStyle(obj,false)[attr];

}
function getClass(parent,sclass){
    var aTag=parent.getElementsByTagName('*');
    var arr=[];
    var i;
    for(i=0;i<aTag.length;i++){
        if(aTag[i].className==sclass){
            arr.push(aTag[i]);
        }
    }
    return arr;
}
function move(obj,json,fn){
    clearInterval(obj.timer);
    obj.timer=setInterval(function(){
        bstop=true;
        for(var attr in json){
            var cur=0;
            if(attr=='opacity'){
                cur=Math.round(getStyle(obj,attr)*100);
            }else{
                cur=parseInt(getStyle(obj,attr));
            }
            var speed=(json[attr]-cur)/5;
            speed=speed>0?Math.ceil(speed):Math.floor(speed);
            if(cur!=json[attr])
                 bstop=false;
            if(attr =='opacity'){
                obj.style.opacity=(cur+speed)/100;
                obj.style.filter='alpha(opacity='+(cur+speed)+')';
            }else{
                obj.style[attr]=cur+speed+'px';
            }
        }
        if(bstop)
        {
            clearInterval(obj.timer);
            fn&&fn();
        }
    },30)
}