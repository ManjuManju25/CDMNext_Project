Feature: Mnemonic Search

Background:
 	Given User has successful logged in
 	
@MnemonicSearch
Scenario Outline: <TCID>:Search for Mnemonic as <Mnemonic>
Given User enters Mnemonic <Mnemonic>
Then  User should get Mnemonic search results in SSI window
Examples: 
	|  TCID   | Mnemonic |
	| "TC_01" | "CHN.NGELCSUM.VOFLQT.ANBN" |
	| "TC_02" | "CHN.IP.NMVAGRFLCU.RBANMN" |
	| "TC_03" | "LAO.IPMQ.VOFLQT.AN" |
	| "TC_04" | "LVA.IPI.RLVOFLFI.MT" |
	| "TC_05" | "LVA.IPI.RLVOFLFI.MTSA" |
	| "TC_06" | "LVA.IPI.RLVOFLQT.MTAGSA" |
	| "TC_07" | "LVA.IPIMFG.RLVOFLFI.MT" |
	| "TC_08" | "LVA.IPIMFG.RLVOFLFI.MTSA" |
	| "TC_09" | "LVA.IPIMQ.RLVOFLFI.MT" |
	

