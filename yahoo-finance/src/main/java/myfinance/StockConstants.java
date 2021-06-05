package myfinance;

public class StockConstants {

    public static String[] sAndp500Stocks = new String[]{
            "MMM", "ABT", "ABBV", "ABMD", "ACN", "ATVI", "ADBE", "AMD", "AAP", "AES", "AFL", "A",
            "APD", "AKAM", "ALK", "ALB", "ARE", "ALXN", "ALGN", "ALLE", "AGN", "ADS", "LNT", "ALL", "GOOGL", "GOOG", "MO",
            "AMZN", "AMCR", "AEE", "AAL", "AEP", "AXP", "AIG", "AMT", "AWK", "AMP", "ABC", "AME", "AMGN", "APH", "ADI",
            "ANSS", "ANTM", "AON", "AOS", "APA", "AIV", "AAPL", "AMAT", "APTV", "ADM", "ARNC", "ANET", "AJG", "AIZ", "ATO",
            "T", "ADSK", "ADP", "AZO", "AVB", "AVY", "BKR", "BLL", "BAC", "BK", "BAX", "BDX", "BRK.B", "BBY", "BIIB", "BLK",
            "BA", "BKNG", "BWA", "BXP", "BSX", "BMY", "AVGO", "BR", "BF.B", "CHRW", "COG", "CDNS", "CPB", "COF", "CPRI",
            "CAH", "KMX", "CCL", "CAT", "CBOE", "CBRE", "CDW", "CE", "CNC", "CNP", "CTL", "CERN", "CF", "SCHW", "CHTR",
            "CVX", "CMG", "CB", "CHD", "CI", "XEC", "CINF", "CTAS", "CSCO", "C", "CFG", "CTXS", "CLX", "CME", "CMS", "KO",
            "CTSH", "CL", "CMCSA", "CMA", "CAG", "CXO", "COP", "ED", "STZ", "COO", "CPRT", "GLW", "CTVA", "COST", "COTY",
            "CCI", "CSX", "CMI", "CVS", "DHI", "DHR", "DRI", "DVA", "DE", "DAL", "XRAY", "DVN", "FANG", "DLR", "DFS", "DISCA",
            "DISCK", "DISH", "DG", "DLTR", "D", "DOV", "DOW", "DTE", "DUK", "DRE", "DD", "DXC", "ETFC", "EMN", "ETN", "EBAY",
            "ECL", "EIX", "EW", "EA", "EMR", "ETR", "EOG", "EFX", "EQIX", "EQR", "ESS", "EL", "EVRG", "ES", "RE", "EXC", "EXPE",
            "EXPD", "EXR", "XOM", "FFIV", "FB", "FAST", "FRT", "FDX", "FIS", "FITB", "FE", "FRC", "FISV", "FLT", "FLIR", "FLS",
            "FMC", "F", "FTNT", "FTV", "FBHS", "FOXA", "FOX", "BEN", "FCX", "GPS", "GRMN", "IT", "GD", "GE", "GIS", "GM", "GPC",
            "GILD", "GL", "GPN", "GS", "GWW", "HRB", "HAL", "HBI", "HOG", "HIG", "HAS", "HCA", "PEAK", "HP", "HSIC", "HSY", "HES",
            "HPE", "HLT", "HFC", "HOLX", "HD", "HON", "HRL", "HST", "HPQ", "HUM", "HBAN", "HII", "IEX", "IDXX", "INFO", "ITW", "ILMN",
            "IR", "INTC", "ICE", "IBM", "INCY", "IP", "IPG", "IFF", "INTU", "ISRG", "IVZ", "IPGP", "IQV", "IRM", "JKHY", "J", "JBHT",
            "SJM", "JNJ", "JCI", "JPM", "JNPR", "KSU", "K", "KEY", "KEYS", "KMB", "KIM", "KMI", "KLAC", "KSS", "KHC", "KR", "LB", "LHX",
            "LH", "LRCX", "LW", "LVS", "LEG", "LDOS", "LEN", "LLY", "LNC", "LIN", "LYV", "LKQ", "LMT", "L", "LOW", "LYB", "MTB", "M",
            "MRO", "MPC", "MKTX", "MAR", "MMC", "MLM", "MAS", "MA", "MKC", "MXIM", "MCD", "MCK", "MDT", "MRK", "MET", "MTD", "MGM",
            "MCHP", "MU", "MSFT", "MAA", "MHK", "TAP", "MDLZ", "MNST", "MCO", "MS", "MOS", "MSI", "MSCI", "MYL", "NDAQ", "NOV", "NTAP",
            "NFLX", "NWL", "NEM", "NWSA", "NWS", "NEE", "NLSN", "NKE", "NI", "NBL", "JWN", "NSC", "NTRS", "NOC", "NLOK", "NCLH", "NRG",
            "NUE", "NVDA", "NVR", "ORLY", "OXY", "ODFL", "OMC", "OKE", "ORCL", "PCAR", "PKG", "PH", "PAYX", "PAYC", "PYPL", "PNR", "PBCT",
            "PEP", "PKI", "PRGO", "PFE", "PM", "PSX", "PNW", "PXD", "PNC", "PPG", "PPL", "PFG", "PG", "PGR", "PLD", "PRU", "PEG", "PSA",
            "PHM", "PVH", "QRVO", "PWR", "QCOM", "DGX", "RL", "RJF", "RTN", "O", "REG", "REGN", "RF", "RSG", "RMD", "RHI", "ROK", "ROL",
            "ROP", "ROST", "RCL", "SPGI", "CRM", "SBAC", "SLB", "STX", "SEE", "SRE", "NOW", "SHW", "SPG", "SWKS", "SLG", "SNA", "SO", "LUV",
            "SWK", "SBUX", "STT", "STE", "SYK", "SIVB", "SYF", "SNPS", "SYY", "TMUS", "TROW", "TTWO", "TPR", "TGT", "TEL", "FTI", "TFX",
            "TXN", "TXT", "TMO", "TIF", "TJX", "TSCO", "TDG", "TRV", "TFC", "TWTR", "TSN", "UDR", "ULTA", "USB", "UAA", "UA", "UNP", "UAL",
            "UNH", "UPS", "URI", "UTX", "UHS", "UNM", "VFC", "VLO", "VAR", "VTR", "VRSN", "VRSK", "VZ", "VRTX", "VIAC", "V", "VNO", "VMC",
            "WRB", "WAB", "WMT", "WBA", "DIS", "WM", "WAT", "WEC", "WFC", "WELL", "WDC", "WU", "WRK", "WY", "WHR", "WMB", "WLTW", "WYNN",
            "XEL", "XRX", "XLNX", "XYL", "YUM", "ZBRA", "ZBH", "ZION", "ZTS"};

    public static String[] russel1000Stocks = new String[]{"TWOU","MMM","ABT","ABBV","ABMD","ACHC","ACN","ATVI","AYI","ADNT","ADBE","ADT",
            "AAP","AMD","ACM","AES","AMG","AFL","AGCO","A","AGIO","AGNC","AL","APD","AKAM","ALK","ALB","AA","ARE","ALXN","ALGN","ALKS","Y",
            "ALLE","ADS","LNT","ALSN","ALL","ALLY","ALNY","GOOGL","GOOG","MO","AMZN","AMCX","DOX","UHAL","AEE","AAL","ACC","AEP","AXP","AFG",
            "AMH","AIG","ANAT","AMT","AWK","AMP","ABC","AME","AMGN","APH","ADI","NLY","ANSS","AR","ANTM","AON","APA","AIV","APLE","AAPL","AMAT",
            "ATR","APTV","WTRG","ARMK","ACGL","ADM","ARD","ANET","AWI","ARW","ASH","AZPN","ASB","AIZ","AGO","T","ATH","TEAM","ATO","ADSK","ADP",
            "AN","AZO","AVB","AGR","AVY","AVT","EQH","AXTA","AXS","BKR","BLL","BAC","BOH","BK","OZK","BKU","BAX","BDX","WRB","BRK.B","BERY",
            "BBY","BYND","BGCP","BIIB","BMRN","BIO","TECH","BKI","BLK","HRB","BLUE","BA","BOKF","BKNG","BAH","BWA","BSX","BDN","BFAM","BHF",
            "BMY","BRX","AVGO","BR","BPYU","BRO","BF.A","BF.B","BRKR","BC","BG","BURL","BWXT","CHRW","CABO","CBT","COG","CACI","CDNS","CZR",
            "CPT","CPB","CMD","COF","CAH","CSL","KMX","CCL","CARR","CRI","CASY","CTLT","CAT","CBOE","CBRE","CDK","CDW","CE","CNC","CDEV","CNP",
            "CDAY","BXP","CF","CRL","CHTR","CHE","LNG","CHK","CVX","CIM","CMG","CHH","CB","CHD","CI","XEC","CINF","CNK","CTAS","CSCO","CIT","C",
            "CFG","CTXS","CLH","CLX","CME","CMS","CNA","CNX","KO","CGNX","CTSH","COHR","CFX","CL","CLNY","CXP","COLM","CMCSA","CMA","CBSH","COMM",
            "CAG","CNDT","COP","ED","STZ","CERN","CPA","CPRT","CLGX","COR","GLW","OFC","CSGP","COST","COTY","CR","CACC","CCI","CCK","CSX","CUBE",
            "CFR","CMI","CW","CVS","CY","CONE","DHI","DHR","DRI","DVA","SITC","DE","DELL","DAL","XRAY","DVN","DXCM","FANG","DKS","DLR","DFS",
            "DISCA","DISCK","DISH","DIS","DHC","DOCU","DLB","DG","DLTR","D","DPZ","CLR","COO","DEI","DOV","DD","DTE","DUK","DRE","DNB","DXC",
            "EXP","EWBC","EMN","ETN","EV","EBAY","SATS","ECL","EIX","EW","EA","EMR","ESRT","EHC","EGN","ENR","ETR","EVHC","EOG","EPAM","EPR",
            "EQT","EFX","EQIX","EQC","ELS","EQR","ERIE","ESS","EL","EEFT","EVBG","EVR","RE","EVRG","ES","UFS","DCI","EXPE","EXPD","STAY","EXR",
            "XOG","XOM","FFIV","FB","FDS","FICO","FAST","FRT","FDX","FIS","FITB","FEYE","FAF","FCNCA","FDC","FHB","FHN","FRC","FSLR","FE","FISV",
            "FLT","FLIR","FND","FLO","FLS","FLR","FMC","FNB","FNF","FL","F","FTNT","FTV","FBHS","FOXA","FOX","BEN","FCX","AJG","GLPI","GPS","EXAS",
            "EXEL","EXC","GTES","GLIBA","GD","GE","GIS","GM","GWR","G","GNTX","GPC","GILD","GPN","GL","GDDY","GS","GT","GRA","GGG","EAF","GHC","GWW",
            "LOPE","GPK","GRUB","GWRE","HAIN","HAL","HBI","THG","HOG","HIG","HAS","HE","HCA","HTA","PEAK","HEI.A","HEI","HP","JKHY","HLF","HSY","HES",
            "GDI","GRMN","IT","HGV","HLT","HFC","HOLX","HD","HON","HRL","HST","HHC","HPQ","HUBB","HPP","HUM","HBAN","HII","HUN","H","IAC","ICUI","IEX",
            "IDXX","INFO","ITW","ILMN","INCY","IR","INGR","PODD","IART","INTC","IBKR","ICE","IGT","IP","IPG","IBM","IFF","INTU","ISRG","IVZ","INVH",
            "IONS","IPGP","IQV","HPE","HXL","HIW","HRC","JAZZ","JBHT","JBGS","JEF","JBLU","JNJ","JCI","JLL","JPM","JNPR","KSU","KAR","K","KDP","KEY",
            "KEYS","KRC","KMB","KIM","KMI","KEX","KLAC","KNX","KSS","KOS","KR","LB","LHX","LH","LRCX","LAMR","LW","LSTR","LVS","LAZ","LEA","LM","LEG",
            "LDOS","LEN","LEN.B","LII","LBRDA","LBRDK","FWONA","IRM","ITT","JBL","JEC","LLY","LECO","LNC","LGF.A","LGF.B","LFUS","LYV","LKQ","LMT","L",
            "LOW","LPLA","LULU","LUMN","LYFT","LYB","MTB","MAC","MIC","M","MSG","MANH","MAN","MRO","MPC","MKL","MKTX","MAR","MMC","MLM","MRVL","MAS",
            "MASI","MA","MTCH","MAT","MXIM","MKC","MCD","MCK","MDU","MPW","MD","MDT","MRK","FWONK","LPT","LSXMA","LSXMK","LSI","CPRI","MIK","MCHP",
            "MU","MSFT","MAA","MIDD","MKSI","MHK","MOH","TAP","MDLZ","MPWR","MNST","MCO","MS","MORN","MOS","MSI","MSM","MSCI","MUR","MYL","NBR","NDAQ",
            "NFG","NATI","NOV","NNN","NAVI","NCR","NKTR","NTAP","NFLX","NBIX","NRZ","NYCB","NWL","NEU","NEM","NWSA","NWS","MCY","MET","MTD","MFA","MGM",
            "JWN","NSC","NTRS","NOC","NLOK","NCLH","NRG","NUS","NUAN","NUE","NTNX","NVT","NVDA","NVR","NXPI","ORLY","OXY","OGE","OKTA","ODFL","ORI",
            "OLN","OHI","OMC","ON","OMF","OKE","ORCL","OSK","OTIS","OUT","OC","OI","PCAR","PKG","PACW","PANW","PGRE","PK","PH","PE","PTEN","PAYX",
            "PAYC","PYPL","NEE","NLSN","NKE","NI","NDSN","PEP","PKI","PRGO","PFE","PCG","PM","PSX","PPC","PNFP","PF","PNW","PXD","ESI","PNC","PII",
            "POOL","BPOP","POST","PPG","PPL","PRAH","PINC","TROW","PFG","PG","PGR","PLD","PFPT","PB","PRU","PTC","PSA","PEG","PHM","PSTG","PVH","QGEN",
            "QRVO","QCOM","PWR","PBF","PEGA","PAG","PNR","PEN","PBCT","RLGY","RP","O","RBC","REG","REGN","RF","RGA","RS","RNR","RSG","RMD","RPAI",
            "RNG","RHI","ROK","ROL","ROP","ROST","RCL","RGLD","RES","RPM","RSPP","R","SPGI","SABR","SAGE","CRM","SC","SRPT","SBAC","HSIC","SLB",
            "SNDR","SCHW","SMG","SEB","SEE","DGX","QRTEA","RL","RRC","RJF","RYN","RTX","NOW","SVC","SHW","SBNY","SLGN","SPG","SIRI","SIX","SKX",
            "SWKS","SLG","SLM","SM","AOS","SJM","SNA","SON","SO","SCCO","LUV","SPB","SPR","SRC","SPLK","SFM","SQ","SSNC","SWK","SBUX","STWD","STT",
            "STLD","SRCL","STE","STL","STOR","SYK","SUI","STI","SIVB","SWCH","SGEN","SEIC","SRE","ST","SCI","SERV","TPR","TRGP","TGT","TCO","TCF",
            "TDOC","TDY","TFX","TDS","TPX","TDC","TER","TEX","TSRO","TSLA","TCBI","TXN","TXT","TFSL","CC","KHC","WEN","TMO","THO","TKR","TJX","TOL",
            "TTC","TSCO","TDG","RIG","TRU","TRV","THS","TPCO","TRMB","TRN","TRIP","SYF","SNPS","SNV","SYY","DATA","TTWO","TMUS","TFC","UBER","UGI",
            "ULTA","ULTI","UMPQ","UAA","UA","UNP","UAL","UPS","URI","USM","X","UTHR","UNH","UNIT","UNVR","OLED","UHS","UNM","URBN","USB","USFD",
            "VFC","MTN","VLO","VMI","VVV","VAR","VVC","VEEV","VTR","VER","VRSN","VRSK","VZ","VSM","VRTX","VIACA","VIAC","TWLO","TWTR","TWO","TYL",
            "TSN","USG","UI","UDR","VMC","WPC","WBC","WAB","WBA","WMT","WM","WAT","WSO","W","WFTLF","WBS","WEC","WRI","WBT","WCG","WFC","WELL",
            "WCC","WST","WAL","WDC","WU","WLK","WRK","WEX","WY","WHR","WTM","WLL","JW.A","WMB","WSM","WLTW","WTFC","WDAY","WP","WYND","WH","VICI",
            "VIRT","V","VC","VST","VMW","VNO","VOYA","ZAYO","ZBRA","ZEN","ZG","Z","ZBH","ZION","ZTS","ZNGA","WYNN","XEL","XRX","XLNX","XPO","XYL",
            "YUMC", "YUM"};

    public static String[] frankfurtStocks = new String[]{"DRI", "TGT", "UUU", "4BSB", "VSC", "ACWN", "ARL", "A4Y", "APM", "ADS", "ADJ", "ADD", "ADL",
            "ADV", "AAH", "AIR", "AIXA", "ASL", "A1OS", "ALV", "AOX", "ACT", "AAD", "AT1", "ART", "AOF", "AAG", "NDA", "AVES", "BNN", "BAS", "BSL",
            "BST", "B5A", "BMW3", "BMW", "BAYN", "BYW", "BYW6", "BBZA", "BC8", "BFSA", "BEI", "BDT", "ACX", "GBF", "B8F", "BIO", "BIO3", "BVB", "BNR",
            "BKHT", "COK", "CPX", "AFX", "CEC", "CEC1", "CSH", "CWC", "C0M", "CBK", "COP", "CON", "CCAP", "1COV", "CSQ", "CE2", "EVD", "DAI", "DAM",
            "LOUD", "DHER", "DEX", "DMRE", "DMP", "DBK", "DB1", "DEQ", "DPW", "DWNI", "DEZ", "DFV", "DLG", "DIC", "DBD", "GIL", "HNL", "DRW8", "DRW3",
            "DBAN", "JB7", "DKG", "PBB", "DTE", "DUE", "DWS", "EOAN", "EUZ", "E4C", "ED4", "EIN3", "ELG", "ZIL2", "ELB", "CAP", "ECX", "ERWE", "EVK",
            "EVT", "EXC", "FAA", "FRU", "FIE", "SIS", "FTK", "FEV", "FPH", "FRA", "FNTN", "FME", "FRE", "FPE3", "FPE", "FBEN", "GTY", "G1A", "GME", "GXI",
            "GSC1", "GFT", "GGS", "GKS", "GFG", "GMM", "GYC", "GLJ", "2HRA", "690D", "HAB", "HHFA", "HNR1", "HLAG", "HAW", "WL6", "HEI", "HDD", "HLE",
            "HFG", "HEN", "HEN3", "5UH", "HLG", "HOT", "HOC", "H24", "HBM", "HBH", "BOSS", "HYQ", "INH", "IFX", "IXX", "INS", "ISH2", "IS7", "IVX", "ISR",
            "IVU", "JEN", "JST", "JUN3", "SDF", "IUR", "KGX", "KCO", "KTA", "KBX", "SKB", "KSC", "KRN", "KU2", "KWS", "LXS", "LEG", "LEI", "LEO", "LIN",
            "TGHN", "LPK", "ECK", "LHA", "M5Z", "MZX", "MXHN", "MBB", "MED", "MDG1", "ILM1", "MRK", "B4B", "B4B3", "MLP", "MOR", "MTX", "MUV2", "MVV1",
            "NA9", "NEM", "NWO", "NXU", "NFN", "NDX1", "NOEJ", "OHB", "OSR", "O4B", "PA8", "PGN", "PAT", "O2C", "PFV", "PSG", "PNE3", "PCZ", "PWO", "PSM",
            "PSAN", "PUM", "TPE", "QSC", "QIA", "RSL2", "RAA", "RHM", "RHK", "RIB", "RY8", "RRTL", "RWE", "SANT", "SFQ", "SZG", "SAP", "SRT", "SRT3", "SHA",
            "SLT", "G24", "YSN", "SJJ", "F3C", "SGL", "SAE", "SIE", "ENR", "SHL", "WAF", "SNG", "LNSX", "SIX2", "SIX3", "AM3D", "S92", "S4A", "SHF", "SYT",
            "SOW", "STM", "SNH", "S9I", "SBS", "SAX", "SZU", "SMHN", "SUR", "SY1", "SYZ", "TEG", "TTK", "TLX", "TMV", "TTR1", "TC1", "O2D", "TLIK", "TKA",
            "8TRA", "UN01", "ULC", "OSP2", "UTDI", "VQT", "VAR1", "VBK", "VIB3", "V6C", "V3V", "VOW", "VOW3", "VBX", "VNA", "VOS", "WCH", "WAC", "WSU",
            "WEW", "WDL", "WUW", "YOC", "ZAL", "TIMA", "ZO1"};

}