package com.zzk.Algorithm;

import java.math.BigDecimal;

/**按照BP网络求解步骤来的，三层BP神经网络*/
/** 已做过归一化处理 */
public class MyBpnet {
	public static void main(String args[]) {
		double saminn[] = {  46.69524436180008,
				34.41232555864797,
				24.797799538096733,
				44.88287436983171,
				46.38388112523927,
				21.07184246081788,
				33.85856618524592,
				46.63773677142123,
				29.342451943240647,
				47.265479914906024,
				35.00881518290845,
				41.39023710822009,
				23.825777535100226,
				30.592899471342932,
				38.07194148047438,
				41.605975268008464,
				37.39623348273412,
				33.93173876833212,
				46.36143059380472,
				46.80544295300014,
				44.39102600957011,
				21.35198490443927,
				49.094290077331294,
				20.970218202761608,
				34.05714450768767,
				43.38934233919109,
				25.557811528760304,
				22.599641702676976,
				42.21623269068488,
				29.55695212324731,
				29.453443919284275,
				46.75726745843416,
				35.679051333057295,
				38.50407471981319,
				42.41771568528103,
				23.944425865774832,
				20.92410843507575,
				32.1971726052425,
				47.23380744175225,
				24.57379725199855,
				36.78747393343906,
				49.90311796419594,
				33.69856458241241,
				30.188920778713594,
				45.08071094230121,
				40.596037756809665,
				23.498413206560368,
				23.38612199413438,
				43.16127256686107,
				48.68862675970615,
				34.77378095987309,
				27.643399227259515,
				28.524637499939026,
				27.705529297144203,
				42.31535121777397,
				25.946325086460966,
				27.469890231953663,
				39.670714654133334,
				35.53659698664897,
				23.224104531942206,
				37.810351202212914,
				44.57254186453595,
				23.505750668553862,
				22.16944273106937,
				49.45831353106675,
				44.29953264130296,
				34.396514990296,
				35.013957675926775,
				36.50783076324519,
				48.90664295095439,
				25.730509073688076,
				45.26637726913523,
				40.17195664493711,
				39.97613756050602,
				31.73559984774952,
				23.29385545802745,
				43.600731922610535,
				26.17896611144908,
				25.032954019447573,
				27.93724194627734,
				47.213648649350574,
				49.92182731315715,
				41.691805983043,
				33.099229661416025,
				36.72524676448607,
				31.181915625244187,
				31.45462510934616,
				23.429813633099855,
				35.52490853931681,
				45.28563655214169,
				28.636513418868134,
				46.856569079810924,
				48.49184827752076,
				25.479372967105324,
				33.84136424317862,
				23.767789363612927,
				25.683708531286783,
				48.66968079961751,
				42.21346442799092,
				43.15457819149626,
				41.632108488375806,
				23.67709913559431,
				20.456898902190847,
				24.95352657273088,
				39.21089413919373,
				25.75203482562217,
				22.30629467747097,
				45.20467186426511,
				26.212777719576874,
				48.94301045629736,
				30.521109036447598,
				36.44995864871175,
				47.877467629818284,
				29.186828102350805,
				42.80183275382269,
				40.045487704746016,
				49.659311740007595,
				35.70702078905507,
				49.290165580012896,
				39.746375740021165,
				41.50490715305452,
				46.461255012878354,
				30.516372467384258,
				47.04610090657476,
				27.831034582202616,
				34.97013692149393,
				46.79572515503839,
				28.31275103309602,
				36.25071898836331,
				30.88918061753481,
				43.15208578906276,
				21.76264042171164,
				22.890123571252392,
				35.152494042917425,
				47.86036876685745,
				28.747310263600628,
				32.87140615534359,
				32.42102557510973,
				37.650787746761225,
				38.702975439629554,
				21.206608139273957,
				38.91002098658288,
				38.5064750861503,
				40.42201640750622,
				31.955038536249614,
				22.449630915144937,
				47.81221375858127,
				34.05418060992213,
				42.04156338232447,
				23.84941654648666,
				31.375714555656355,
				48.43067960804459,
				40.61561960480799,
				34.291775306138135,
				47.54402497693815,
				46.92745055767911,
				35.25069239240333,
				22.57113616793286,
				20.276347988458856,
				32.144353779548034,
				42.64143021529703,
				48.525042610189914,
				43.61069921495506,
				45.17516296296421,
				23.750478544937167,
				24.970059365654684,
				41.475521483253516,
				49.178731061813444,
				31.589539852376184,
				49.85972063906145,
				49.248528617209445,
				49.33476678871273,
				23.98910110384113,
				43.22354365076859,
				26.85374691156187,
				32.078204283182146,
				33.81867004245912,
				29.72542554941392,
				47.513875164192754,
				45.754193810797204,
				35.16430001841661,
				27.39653822605703,
				41.53874884994721,
				22.521294077341004,
				25.952604126914295,
				46.25213167461001,
				30.731906737178285,
				27.453476516583496,
				35.43037098072093,
				47.09345540775009,
				36.1358692238509,
				45.352128022877665,
				48.76632429809059,
				40.825301901400714,
				29.91297265596844,
				28.777254208954005,
				20.83649159333589,
				22.08647728013293,
				21.172219700320944,
				32.24265258085877,
				46.987064063481405,
				47.89479593018617,
				25.503824652409392,
				27.39286714592682,
				40.23855144602652,
				32.349993976527294,
				48.87176572017577,
				32.290273916643265,
				22.00246709730869,
				32.21725845621384,
				28.34086074409036,
				44.68871317677271,
				36.92668404549035,
				25.43085712794426,
				24.878527960044252,
				24.35560681657783,
				41.96803997428805,
				35.21165946950198,
				27.17258433655298,
				33.12756558717162,
				35.210683902007155,
				26.584133026533515,
				40.04509562014349,
				33.44502979744318,
				21.30607834546804,
				29.607686252160182,
				46.61846562967686,
				46.60953086114152,
				47.70549576483611,
				44.6040513385841,
				29.903631293265214,
				30.942719137293185,
				29.088266791397707,
				29.06666530586528,
				26.93138983345727,
				27.39933590806728,
				46.558965792175314,
				43.77982787923176,
				36.936563375454085,
				35.99686551349104,
				33.29412900678891,
				46.95470820022889,
				24.430883515671905,
				20.672643355612365,
				49.36404142401342,
				29.906052589762083,
				48.264138844808954,
				32.86474888231087,
				35.437523411026966,
				45.9477682919942,
				38.974303363135355,
				45.2360583053033,
				47.99760460278743,
				35.77733397015722,
				38.866046450487616,
				46.52136299245099,
				27.553361509248465,
				27.648291800479537,
				42.33317845552074,
				26.475541021306448,
				26.128131592181656,
				39.09688104949177,
				47.954275762271266,
				36.33627746028515,
				21.036752368484123,
				28.893151306793598,
				38.841887874755486,
				25.08789766636602,
				48.63435979215104,
				33.22871213516878,
				33.614410276346206,
				25.12342857568065,
				44.326744945650105,
				38.932554773488775,
				27.18586899580187,
				42.6500320394673,
				23.67715502402111,
				28.723185058163807,
				38.33254528512708,
				48.36851536682127,
				43.92686559691552,
				39.15961345831155,
				39.696534929067695,
				42.58066507439365,
				35.66676661278784,
				41.0455213914619,
				35.52500657855494,
				25.938701257078094,
				20.75463166944347,
				44.57025176043274,
				23.020099365984457,
				22.549189184004447,
				24.86765055294189,
				37.43702941713906,
				34.68807074297802,
				26.07930074809261,
				21.3122378344813,
				33.633158242553236,
				21.527482604132484,
				41.886357727397645,
				26.883056355085078,
				33.33869898982533,
				40.28486468967074,
				49.002140956796396,
				30.670590921896647,
				20.74945259712348,
				22.33250259138577,
				25.05149255452065,
				32.76156478870354,
				26.306866589996048,
				36.98663243860577,
				24.870286157711234,
				31.75888924458274,
				22.981764894345865,
				28.28552096566004,
				39.71089403565653,
				37.967756248628625,
				32.85062796165919,
				31.385567576654587,
				38.48381001735329,
				22.95193357221793,
				40.2324088092384,
				32.809748153254056,
				45.482152400085965,
				45.95920388959003,
				21.12069908657708,
				37.79638220499028,
				20.47130881298577,
				33.4473507671358,
				25.550344047841627,
				27.947382643268377,
				36.899030709754626,
				39.611981314676015,
				49.87939506648073,
				23.263815935768477,
				42.291835628677994,
				33.424926406005085,
				39.74660318784197,
				34.48277799577289,
				41.651623880181795,
				31.23686219829884,
				31.681431912245955,
				44.393256870447416,
				49.851951279606794,
				33.48022494138396,
				41.997885082733625,
				30.50982365356094,
				42.65647010941019,
				39.42841213479895,
				45.695229081634075,
				36.12167879037513,
				38.0425681577622,
				45.32469171519137,
				35.617989821274556,
				22.310728421295366,
				20.011306833774967,
				28.489147634594353,
				33.0944023418645,
				40.046067609591994,
				26.000290126067984,
				33.24442454237406,
				35.676790015284055,
				28.913389776158027,
				46.38915628847093,
				33.67096010031728,
				25.44913530394058,
				47.42653349736689,
				40.397918619108864,
				23.30979375411002,
				22.646423465821222,
				29.19454256767391,
				46.92643346224831,
				42.9759879749889,
				24.047112722990974,
				49.48128864945518,
				21.568829195061888,
				34.828108477110845,
				23.75439460471691,
				47.895870941373474,
				42.15975593628084,
				23.75912170714647,
				35.57371173465757,
				25.09069136242777,
				24.76988981461101,
				46.03151317926448,
				21.223273114259964,
				24.420268773820037,
				20.066147278948968,
				39.874332548083615,
				27.081133004205014,
				23.527523649566575,
				46.38762397385529,
				33.49229683547892,
				24.076676451457836,
				45.77544430008898,
				30.761326227075216,
				22.607016308122873,
				20.67615477085527,
				27.33071266392464,
				42.39229197864634,
				42.25781148446101,
				47.69122311505061,
				32.53204505701133,
				24.910760137826713,
				26.134529899553748,
				45.856207633759,
				37.93966383759846,
				23.844590134604378,
				41.19717873049507,
				22.774148969633984,
				44.163502623064744,
				44.408175165339095,
				35.757117381090865,
				34.92345105045039,
				24.206407285631535,
				31.75964628114898,
				45.55197894929859,
				22.946264300855958,
				37.634773948776655,
				31.376209916421672,
				24.641405790176954,
				24.40653754777398,
				41.40273454781078,
				41.13300272661468,
				36.1831055518158,
				37.6099495039784,
				20.60717317058706,
				29.043902580706145,
				32.31866546632858,
				42.9197588036579,
				25.83952341697868,
				31.433276412175754,
				22.50597347709099,
				24.281871326599077,
				48.126481654389366,
				25.55569314869823,
				45.68001805757574,
				33.389255352891084,
				37.71542725657063,
				48.36617909150593,
				33.60627209119192,
				22.070106615471857,
				29.161519656377997,
				49.26663451289073,
				40.71077417270049,
				45.07597714623889,
				22.312124544343582,
				29.214587577414747,
				39.52844428725055,
				25.475366440574195,
				36.86036891204317,
				21.57849473594948,
				40.70610510548032,
				38.32508811544301,
				27.153317785498245,
				41.55935287735658,
				22.229085316352556,
				45.195999723249884,
				23.891436469981436,
				20.871441375404277,
				24.21021651204417,
				32.47149772660917,
				20.244654956901698,
				32.685532681118694,
				33.18744515599963,
				40.11647214730276,
				41.73654394046184,
				28.585997077896355,
				33.42122153850688,
				44.831205745488646,
				22.01177894238424,
				24.47873535203191,
				22.165221016836227,
				42.15900417373496,
				30.303228228585365,
				36.00994548599121,
				31.303906090423272,
				26.208151467301338,
				41.0536863909618,
				46.116265919980705,
				39.10783385264834,
				23.17805164454755,
				21.72344798026125,
				47.82488538778763,
				23.152557589689867,
				35.84625564626335,
				31.328571730141135,
				34.357758874795046,
				38.679366310112044,
				20.577326877894492,
				49.70587488179797,
				35.96711461102344,
				35.84606220389331,
				36.256335872148235,
				35.88936302362729,
				28.739983564434816,
				24.423360230130186,
				25.829035022828197,
				23.308964711884602,
				24.857531086590058 };// 神经元输入，输入神经元数目为8
		double maxmin[] = new double[2];// 求训练数据最大值和最小值
		maxmin = maxmin(saminn);

		double samin[] = preprocess(maxmin[0], maxmin[1], saminn);// 输入做归一化处理，归一化公式
																	// x'=(x-min)/(max-x)

		double samoutt[] = {  46.69524436180008,
				34.41232555864797,
				24.797799538096733,
				44.88287436983171,
				46.38388112523927,
				21.07184246081788,
				33.85856618524592,
				46.63773677142123,
				29.342451943240647,
				47.265479914906024,
				35.00881518290845,
				41.39023710822009,
				23.825777535100226,
				30.592899471342932,
				38.07194148047438,
				41.605975268008464,
				37.39623348273412,
				33.93173876833212,
				46.36143059380472,
				46.80544295300014,
				44.39102600957011,
				21.35198490443927,
				49.094290077331294,
				20.970218202761608,
				34.05714450768767,
				43.38934233919109,
				25.557811528760304,
				22.599641702676976,
				42.21623269068488,
				29.55695212324731,
				29.453443919284275,
				46.75726745843416,
				35.679051333057295,
				38.50407471981319,
				42.41771568528103,
				23.944425865774832,
				20.92410843507575,
				32.1971726052425,
				47.23380744175225,
				24.57379725199855,
				36.78747393343906,
				49.90311796419594,
				33.69856458241241,
				30.188920778713594,
				45.08071094230121,
				40.596037756809665,
				23.498413206560368,
				23.38612199413438,
				43.16127256686107,
				48.68862675970615,
				34.77378095987309,
				27.643399227259515,
				28.524637499939026,
				27.705529297144203,
				42.31535121777397,
				25.946325086460966,
				27.469890231953663,
				39.670714654133334,
				35.53659698664897,
				23.224104531942206,
				37.810351202212914,
				44.57254186453595,
				23.505750668553862,
				22.16944273106937,
				49.45831353106675,
				44.29953264130296,
				34.396514990296,
				35.013957675926775,
				36.50783076324519,
				48.90664295095439,
				25.730509073688076,
				45.26637726913523,
				40.17195664493711,
				39.97613756050602,
				31.73559984774952,
				23.29385545802745,
				43.600731922610535,
				26.17896611144908,
				25.032954019447573,
				27.93724194627734,
				47.213648649350574,
				49.92182731315715,
				41.691805983043,
				33.099229661416025,
				36.72524676448607,
				31.181915625244187,
				31.45462510934616,
				23.429813633099855,
				35.52490853931681,
				45.28563655214169,
				28.636513418868134,
				46.856569079810924,
				48.49184827752076,
				25.479372967105324,
				33.84136424317862,
				23.767789363612927,
				25.683708531286783,
				48.66968079961751,
				42.21346442799092,
				43.15457819149626,
				41.632108488375806,
				23.67709913559431,
				20.456898902190847,
				24.95352657273088,
				39.21089413919373,
				25.75203482562217,
				22.30629467747097,
				45.20467186426511,
				26.212777719576874,
				48.94301045629736,
				30.521109036447598,
				36.44995864871175,
				47.877467629818284,
				29.186828102350805,
				42.80183275382269,
				40.045487704746016,
				49.659311740007595,
				35.70702078905507,
				49.290165580012896,
				39.746375740021165,
				41.50490715305452,
				46.461255012878354,
				30.516372467384258,
				47.04610090657476,
				27.831034582202616,
				34.97013692149393,
				46.79572515503839,
				28.31275103309602,
				36.25071898836331,
				30.88918061753481,
				43.15208578906276,
				21.76264042171164,
				22.890123571252392,
				35.152494042917425,
				47.86036876685745,
				28.747310263600628,
				32.87140615534359,
				32.42102557510973,
				37.650787746761225,
				38.702975439629554,
				21.206608139273957,
				38.91002098658288,
				38.5064750861503,
				40.42201640750622,
				31.955038536249614,
				22.449630915144937,
				47.81221375858127,
				34.05418060992213,
				42.04156338232447,
				23.84941654648666,
				31.375714555656355,
				48.43067960804459,
				40.61561960480799,
				34.291775306138135,
				47.54402497693815,
				46.92745055767911,
				35.25069239240333,
				22.57113616793286,
				20.276347988458856,
				32.144353779548034,
				42.64143021529703,
				48.525042610189914,
				43.61069921495506,
				45.17516296296421,
				23.750478544937167,
				24.970059365654684,
				41.475521483253516,
				49.178731061813444,
				31.589539852376184,
				49.85972063906145,
				49.248528617209445,
				49.33476678871273,
				23.98910110384113,
				43.22354365076859,
				26.85374691156187,
				32.078204283182146,
				33.81867004245912,
				29.72542554941392,
				47.513875164192754,
				45.754193810797204,
				35.16430001841661,
				27.39653822605703,
				41.53874884994721,
				22.521294077341004,
				25.952604126914295,
				46.25213167461001,
				30.731906737178285,
				27.453476516583496,
				35.43037098072093,
				47.09345540775009,
				36.1358692238509,
				45.352128022877665,
				48.76632429809059,
				40.825301901400714,
				29.91297265596844,
				28.777254208954005,
				20.83649159333589,
				22.08647728013293,
				21.172219700320944,
				32.24265258085877,
				46.987064063481405,
				47.89479593018617,
				25.503824652409392,
				27.39286714592682,
				40.23855144602652,
				32.349993976527294,
				48.87176572017577,
				32.290273916643265,
				22.00246709730869,
				32.21725845621384,
				28.34086074409036,
				44.68871317677271,
				36.92668404549035,
				25.43085712794426,
				24.878527960044252,
				24.35560681657783,
				41.96803997428805,
				35.21165946950198,
				27.17258433655298,
				33.12756558717162,
				35.210683902007155,
				26.584133026533515,
				40.04509562014349,
				33.44502979744318,
				21.30607834546804,
				29.607686252160182,
				46.61846562967686,
				46.60953086114152,
				47.70549576483611,
				44.6040513385841,
				29.903631293265214,
				30.942719137293185,
				29.088266791397707,
				29.06666530586528,
				26.93138983345727,
				27.39933590806728,
				46.558965792175314,
				43.77982787923176,
				36.936563375454085,
				35.99686551349104,
				33.29412900678891,
				46.95470820022889,
				24.430883515671905,
				20.672643355612365,
				49.36404142401342,
				29.906052589762083,
				48.264138844808954,
				32.86474888231087,
				35.437523411026966,
				45.9477682919942,
				38.974303363135355,
				45.2360583053033,
				47.99760460278743,
				35.77733397015722,
				38.866046450487616,
				46.52136299245099,
				27.553361509248465,
				27.648291800479537,
				42.33317845552074,
				26.475541021306448,
				26.128131592181656,
				39.09688104949177,
				47.954275762271266,
				36.33627746028515,
				21.036752368484123,
				28.893151306793598,
				38.841887874755486,
				25.08789766636602,
				48.63435979215104,
				33.22871213516878,
				33.614410276346206,
				25.12342857568065,
				44.326744945650105,
				38.932554773488775,
				27.18586899580187,
				42.6500320394673,
				23.67715502402111,
				28.723185058163807,
				38.33254528512708,
				48.36851536682127,
				43.92686559691552,
				39.15961345831155,
				39.696534929067695,
				42.58066507439365,
				35.66676661278784,
				41.0455213914619,
				35.52500657855494,
				25.938701257078094,
				20.75463166944347,
				44.57025176043274,
				23.020099365984457,
				22.549189184004447,
				24.86765055294189,
				37.43702941713906,
				34.68807074297802,
				26.07930074809261,
				21.3122378344813,
				33.633158242553236,
				21.527482604132484,
				41.886357727397645,
				26.883056355085078,
				33.33869898982533,
				40.28486468967074,
				49.002140956796396,
				30.670590921896647,
				20.74945259712348,
				22.33250259138577,
				25.05149255452065,
				32.76156478870354,
				26.306866589996048,
				36.98663243860577,
				24.870286157711234,
				31.75888924458274,
				22.981764894345865,
				28.28552096566004,
				39.71089403565653,
				37.967756248628625,
				32.85062796165919,
				31.385567576654587,
				38.48381001735329,
				22.95193357221793,
				40.2324088092384,
				32.809748153254056,
				45.482152400085965,
				45.95920388959003,
				21.12069908657708,
				37.79638220499028,
				20.47130881298577,
				33.4473507671358,
				25.550344047841627,
				27.947382643268377,
				36.899030709754626,
				39.611981314676015,
				49.87939506648073,
				23.263815935768477,
				42.291835628677994,
				33.424926406005085,
				39.74660318784197,
				34.48277799577289,
				41.651623880181795,
				31.23686219829884,
				31.681431912245955,
				44.393256870447416,
				49.851951279606794,
				33.48022494138396,
				41.997885082733625,
				30.50982365356094,
				42.65647010941019,
				39.42841213479895,
				45.695229081634075,
				36.12167879037513,
				38.0425681577622,
				45.32469171519137,
				35.617989821274556,
				22.310728421295366,
				20.011306833774967,
				28.489147634594353,
				33.0944023418645,
				40.046067609591994,
				26.000290126067984,
				33.24442454237406,
				35.676790015284055,
				28.913389776158027,
				46.38915628847093,
				33.67096010031728,
				25.44913530394058,
				47.42653349736689,
				40.397918619108864,
				23.30979375411002,
				22.646423465821222,
				29.19454256767391,
				46.92643346224831,
				42.9759879749889,
				24.047112722990974,
				49.48128864945518,
				21.568829195061888,
				34.828108477110845,
				23.75439460471691,
				47.895870941373474,
				42.15975593628084,
				23.75912170714647,
				35.57371173465757,
				25.09069136242777,
				24.76988981461101,
				46.03151317926448,
				21.223273114259964,
				24.420268773820037,
				20.066147278948968,
				39.874332548083615,
				27.081133004205014,
				23.527523649566575,
				46.38762397385529,
				33.49229683547892,
				24.076676451457836,
				45.77544430008898,
				30.761326227075216,
				22.607016308122873,
				20.67615477085527,
				27.33071266392464,
				42.39229197864634,
				42.25781148446101,
				47.69122311505061,
				32.53204505701133,
				24.910760137826713,
				26.134529899553748,
				45.856207633759,
				37.93966383759846,
				23.844590134604378,
				41.19717873049507,
				22.774148969633984,
				44.163502623064744,
				44.408175165339095,
				35.757117381090865,
				34.92345105045039,
				24.206407285631535,
				31.75964628114898,
				45.55197894929859,
				22.946264300855958,
				37.634773948776655,
				31.376209916421672,
				24.641405790176954,
				24.40653754777398,
				41.40273454781078,
				41.13300272661468,
				36.1831055518158,
				37.6099495039784,
				20.60717317058706,
				29.043902580706145,
				32.31866546632858,
				42.9197588036579,
				25.83952341697868,
				31.433276412175754,
				22.50597347709099,
				24.281871326599077,
				48.126481654389366,
				25.55569314869823,
				45.68001805757574,
				33.389255352891084,
				37.71542725657063,
				48.36617909150593,
				33.60627209119192,
				22.070106615471857,
				29.161519656377997,
				49.26663451289073,
				40.71077417270049,
				45.07597714623889,
				22.312124544343582,
				29.214587577414747,
				39.52844428725055,
				25.475366440574195,
				36.86036891204317,
				21.57849473594948,
				40.70610510548032,
				38.32508811544301,
				27.153317785498245,
				41.55935287735658,
				22.229085316352556,
				45.195999723249884,
				23.891436469981436,
				20.871441375404277,
				24.21021651204417,
				32.47149772660917,
				20.244654956901698,
				32.685532681118694,
				33.18744515599963,
				40.11647214730276,
				41.73654394046184,
				28.585997077896355,
				33.42122153850688,
				44.831205745488646,
				22.01177894238424,
				24.47873535203191,
				22.165221016836227,
				42.15900417373496,
				30.303228228585365,
				36.00994548599121,
				31.303906090423272,
				26.208151467301338,
				41.0536863909618,
				46.116265919980705,
				39.10783385264834,
				23.17805164454755,
				21.72344798026125,
				47.82488538778763,
				23.152557589689867,
				35.84625564626335,
				31.328571730141135,
				34.357758874795046,
				38.679366310112044,
				20.577326877894492,
				49.70587488179797,
				35.96711461102344,
				35.84606220389331,
				36.256335872148235,
				35.88936302362729,
				28.739983564434816,
				24.423360230130186,
				25.829035022828197,
				23.308964711884602,
				24.857531086590058 };// 用原输入数据作为神经元输出来训练网络
		double maxminout[] = maxmin(samoutt);
		double samout[] = preprocess(maxminout[0], maxminout[1], samoutt);// 输出做归一化处理

		int times = 10000;// 训练次数
		double rate = 0.5;// 学习率
		int in = samin.length;// 输入神经元个数
		int out = samout.length;// 输出神经元个数
		double h = Math.sqrt((0.43 * in * out) + 0.12 * out * out + 2.54 * in
				+ 0.77 * out + 0.35) + 0.51;// 按文献上公式求隐含层个数
		BigDecimal b = new BigDecimal(h).setScale(0, BigDecimal.ROUND_HALF_UP);
		int hidN = (int) b.intValue();

		BP bp = new BP(in, hidN, out, times, rate);// 创建BP神经网络
		bp.train(samin, samout);// 利用BP神经网络进行训练
//		for (int i = 0; i < hidN; i++) {// 输出训练后网络输入层到隐含层权值和阈值
//			for (int j = 0; j < in; j++) {
//				System.out.println("输入层到隐含层权值阈值：      " + bp.wyh[i][j] + "   ");
//			}
//			System.out.println();
//		}
//		for (int i = 0; i < out; i++) {// 输出训练后隐含层到输出层权值和阈值
//			for (int j = 0; j < hidN; j++) {
//				System.out.println("隐含层到输出层权值阈值：      " + bp.wyo[i][j]);
//			}
//			System.out.println();
//		}
		double testinn[] = { 44.92954026415439,
				28.84587875997763,
				46.60684468544838,
				21.827415912414963,
				49.33979468597225,
				29.374773020721058,
				40.10583523467957,
				27.75973474434339,
				34.623706744409574,
				45.041937822878,
				26.712630427039983,
				25.359135587012283,
				37.18161858738601,
				28.794322089018415,
				35.36360486996405,
				32.51512774371497,
				26.555100314369035,
				47.940142117528495,
				21.54332024291784,
				43.83679508236536,
				39.034812436646405,
				29.728483036972627,
				22.54679742347751,
				35.23601295141223,
				37.55776667546222,
				28.170003430951134,
				30.279205979531277,
				25.715360890313228,
				32.11608708242669,
				44.013717325817794,
				25.00940127068763,
				21.18097592091561,
				46.64742936481574,
				38.33975849562097,
				25.710563495893318,
				32.864285749336354,
				48.56275818483452,
				34.710447112503836,
				48.27546667309837,
				41.6376964771552,
				45.69023019319639,
				45.24190095531824,
				41.98571099496141,
				29.148015056031966,
				22.474476606838664,
				42.315855531816624,
				47.14355216817597,
				27.26755006845553,
				32.76862369529365,
				39.94628806414819,
				22.74175710708667,
				28.87648185428253,
				40.49194779934219,
				27.047845358853067,
				32.45120090340011,
				35.441304547262746,
				31.799091000788177,
				29.023011010473592,
				40.04773467204522,
				20.242788150740342,
				33.217323302103935,
				44.19236399845627,
				31.679142246281053,
				20.43308135040977,
				49.4563811147209,
				47.637208034497704,
				32.089790796938466,
				46.36526013520853,
				22.280956088130615,
				27.006258603525655,
				45.07490114993206,
				22.839792182707672,
				37.958955967962474,
				42.75801884249161,
				45.02813472441137,
				24.05105337335177,
				35.35920846167695,
				49.167870833429134,
				26.47550546513713,
				32.09321905703176,
				29.770325098073535,
				22.223859262886098,
				21.955425934898606,
				27.898508290809993,
				38.94798926180908,
				26.267539301263255,
				45.50897390202081,
				43.431939183441756,
				47.7709684495798,
				32.90620548300804,
				49.38628904168079,
				34.85543581594429,
				36.19672629250984,
				43.330215868426976,
				45.35427997316086,
				28.200269489544425,
				31.955519519389895,
				48.71408089327875,
				29.207643937430863,
				21.850526571248444,
				34.607442908171606,
				42.862366293946685,
				27.739472609593562,
				23.841432041120733,
				31.209912477280817,
				36.68142437233561,
				31.51954065675927,
				26.615061468998654,
				45.903637746415285,
				45.41535312687366,
				34.357644534721715,
				47.452115815777944,
				46.22316749883533,
				26.879532816377058,
				41.296182719572265,
				29.312126712423584,
				47.87365240681778,
				42.15748900706759,
				21.380434228475615,
				24.265629616643793,
				27.088508329507434,
				49.396768145580374,
				39.296829090304236,
				30.090499211544362,
				25.493210644784735,
				26.446935687428088,
				31.248749213975692,
				49.930830743077294,
				26.648500845832434,
				49.127705274121126,
				45.15626097652993,
				45.18041368511105,
				36.131825725574025,
				38.89765817704261,
				23.420400298843454,
				22.954017723408,
				38.13889389196474,
				46.61392222899708,
				28.084505166639403,
				21.648381704616185,
				41.147750343492646,
				47.93059300154114,
				23.25432802140412,
				31.17097373833525,
				43.18585629846065,
				40.67861225694648,
				48.10548962476307,
				38.428254952831296,
				33.67616865699894,
				35.30224601509636,
				25.7111214392462,
				33.61635194572555,
				23.711294267215678,
				26.09720368196202,
				38.26433935940092,
				28.745725081071495,
				39.91531311487721,
				33.602889265678336,
				28.049500452097753,
				26.657579724190626,
				28.800936994503346,
				27.046180093183096,
				25.732972414206927,
				36.55343969714119,
				28.71519109558459,
				20.21655021977793,
				33.19845978482769,
				30.76048668074694,
				35.08987896285599,
				24.572289084359127,
				37.24371405566623,
				47.09392798575298,
				41.77361275211635,
				29.73497961201455,
				22.984763480407892,
				21.753827404968693,
				36.72026431504291,
				23.824317596034508,
				21.78058967666847,
				29.20752152834329,
				24.244207543181336,
				44.317789214185495,
				27.895467241524756,
				27.959893309616653,
				28.425805987717254,
				34.289633481036326,
				40.95800219725707,
				24.502459130210852,
				43.06111167881942,
				38.990941542341574,
				37.555167975994365,
				22.05840488023981,
				32.79781674784268,
				43.7776738031069,
				25.016473480538025,
				36.004356081001035,
				27.785021784362314,
				26.375782572928966,
				43.59765900225716,
				24.050863251030275
};// 测试数据
		double test[] = maxmin(testinn);
		double testin[] = preprocess(test[0], test[1], testinn);// 测试数据做归一化处理
		double testoutt[] = new double[testin.length];// 测试输入输出数据个数一样
		testoutt = bp.getResult(testin);
		double testout[] = revprocess(test[0], test[1], testoutt);// 网络输出结果做反归一化处理
		for (int i = 0; i < testout.length; i++) {
			System.out.println(testout[i]+",");
		}
		System.out.println();

	}

	/** 求最大值最小值 **/

	public static double[] maxmin(double[] saminn) {
		double a[] = new double[2];
		double max = saminn[0], min = saminn[0];
		for (int i = 1; i < saminn.length; i++) {
			if (max < saminn[i])
				max = saminn[i];
			if (min > saminn[i])
				min = saminn[i];
		}
		a[0] = max;
		a[1] = min;
		return a;

	}

	/** 归一化处理 **/

	public static double[] preprocess(double max, double min, double[] saminn) {
		// System.out.println(max+" "+min);
		double samin[] = new double[saminn.length];
		for (int i = 0; i < samin.length; i++) {
			samin[i] = (saminn[i] - min) / (max - min);
			// System.out.println(samin[i]);
		}
		return samin;

	}

	/** 反归一化处理 **/

	public static double[] revprocess(double max, double min, double[] testoutt) {
		double testout[] = new double[testoutt.length];
		for (int i = 0; i < testout.length; i++) {
			testout[i] = testoutt[i] * (max - min) + min;
		}
		return testout;
	}

}

// BP神经网络实现

class BP {
	double wyh[][], wyo[][];// 权值，最后一行为阈值
	int hidN;// 隐含层单元个数
	int inN;// 输入单元个数
	int outN;// 输出单元个数
	int times;// 迭代次数
	double rate;// 学习率
	boolean trained = false;// 保证测试前先训练

	BP(int inN, int hidN, int outN, int times, double rate) {// 构造函数
		this.inN = inN;
		this.outN = outN;
		this.hidN = hidN;
		this.rate = rate;
		this.times = times;
	}

	public void train(double inData[],double outData[]){//网络训练
double err=0;//总体误差
int count=times;
double temphid[]=new double[hidN];//保存隐含层输出
double tempout[]=new double[outN];//保存输出层输出
double errout[]=new double[outN];//输出层各神经元误差
double errhid[]=new double[hidN];//隐含层各神经元误差

wyh=new double[hidN][inN+1];//最后一行为隐含层阈值



for(int i=0;i<hidN;i++){
for(int j=0;j<=inN;j++){
wyh[i][j]=Math.random()-0.5;//初始化权值和阈值
//System.out.println(wyh[i][j]);
}
}
//System.out.println();
wyo=new double[outN][hidN+1];//最后一行为计算输出的阈值
for(int i=0;i<outN;i++){
for(int j=0;j<=hidN;j++){
wyo[i][j]=Math.random()-0.5;//初始化权值和阈值
//System.out.println(wyo[i][j]);
}
}
while((count--)>0){
for(int i=0;i<hidN;i++){//遍历每个隐含单元的结果
temphid[i]=0;
for(int j=0;j<inN;j++){
temphid[i]+=wyh[i][j]*inData[j];
} 
temphid[i]+=wyh[i][inN];
temphid[i]=1.0/(1+Math.exp(-temphid[i]));
//System.out.println(temphid[i]);
}

for(int i=0;i<outN;i++){//计算每个输出层单元的结果
tempout[i]=0;
for(int j=0;j<hidN;j++){
tempout[i]+=wyo[i][j]*temphid[j];
}
tempout[i]+=wyo[i][hidN];
tempout[i]=1.0/(1+Math.exp(-tempout[i]));
}
//每个输出单元的计算误差 

for(int i=0;i<outN;++i ){
errout[i]=tempout[i]*(1-tempout[i])*(outData[i]-tempout[i]);
err+=Math.pow((outData[i]-tempout[i]), 2);
}
err=err/2;//最终误差计算
//计算每个隐含层单元的误差
double errh=0;
for(int i=0;i<hidN;i++){
for(int j=0;j<outN;j++){
errh+=errout[j]*wyo[j][i];
}
errhid[i]=temphid[i]*(1-temphid[i])*errh;
}

//改变输出层权值
for(int i=0;i<outN;i++){
for(int j=0;j<hidN;j++){
wyo[i][j]+=rate*temphid[j]*errout[i];
}
wyo[i][hidN]+=rate*errout[i];//改变阈值
}

//改变隐含层权值和阈值
for(int i=0;i<hidN;i++){
for(int j=0;j<inN;j++){
wyh[i][j]+=rate*inData[j]*errhid[i];
}
wyh[i][inN]+=rate*errhid[i];
}
if(err<0.0001)
break;

}

System.out.println("训练次数："+count+"   ，训练误差"+err);

trained=true;
}

	public double[] getResult(double inData[]) {// 得到测试数据的输出
		double temphid[] = new double[hidN];// 隐含层个数暂时不变
		double tempout[] = new double[inData.length];// 测试数据输入多少个输出就多少个
		if (trained == false)
			return null;
		for (int i = 0; i < hidN; i++) {
			temphid[i] = 0;
			for (int j = 0; j < inData.length; j++) {
				temphid[i] += wyh[i][j] * inData[j];
			}
			temphid[i] += wyh[i][inData.length];
			temphid[i] = 1.0 / (1 + Math.exp(-temphid[i]));
		}
		for (int i = 0; i < tempout.length; i++) {
			tempout[i] = 0;
			for (int j = 0; j < hidN; j++) {
				tempout[i] += wyo[i][j] * temphid[j];
			}
			tempout[i] += wyo[i][hidN];
			tempout[i] = 1 / (1 + Math.exp(-tempout[i]));// 测试数据的输出
		}
		return tempout;// 返回测网络输出的测试结果
	}
}