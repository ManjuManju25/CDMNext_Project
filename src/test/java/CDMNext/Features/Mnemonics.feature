Feature: Mnemonics

Background:
 	Given User has successful logged in
 	
@MnemonicSearch 	
Scenario: TC_KeywordSearch_01 : Search for an Mnemonic as "CHN.NGELCSUM.VOFLQT.ANBN"
Given User enters Mnemonic "CHN.NGELCSUM.VOFLQT.ANBN"
Then  User should get Mnemonic search results in SSI window

@MnemonicSearch 	
Scenario: TC_KeywordSearch_02 : Search for an Mnemonic as "CHN.IP.NMVAGRFLCU.RBANMN"
Given User enters Mnemonic "CHN.IP.NMVAGRFLCU.RBANMN"
Then  User should get Mnemonic search results in SSI window	

@MnemonicSearch 	
Scenario: TC_KeywordSearch_03 : Search for an Mnemonic as "LAO.IPMQ.VOFLQT.AN"
Given User enters Mnemonic "LAO.IPMQ.VOFLQT.AN"
Then  User should get Mnemonic search results in SSI window	

@MnemonicSearch 	
Scenario: TC_KeywordSearch_04 : Search for an Mnemonic as "LVA.IPI.RLVOFLFI.MT"
Given User enters Mnemonic "LVA.IPI.RLVOFLFI.MT"
Then  User should get Mnemonic search results in SSI window	

@MnemonicSearch 	
Scenario: TC_KeywordSearch_05 : Search for an Mnemonic as "LVA.IPI.RLVOFLFI.MTSA"
Given User enters Mnemonic "LVA.IPI.RLVOFLFI.MTSA"
Then  User should get Mnemonic search results in SSI window	

@MnemonicSearch 	
Scenario: TC_KeywordSearch_06 : Search for an Mnemonic as "LVA.IPI.RLVOFLQT.MTAGSA"
Given User enters Mnemonic "LVA.IPI.RLVOFLQT.MTAGSA"
Then  User should get Mnemonic search results in SSI window	

@MnemonicSearch 	
Scenario: TC_KeywordSearch_07 : Search for an Mnemonic as "LVA.IPIMFG.RLVOFLFI.MT"
Given User enters Mnemonic "LVA.IPIMFG.RLVOFLFI.MT"
Then  User should get Mnemonic search results in SSI window	

@MnemonicSearch 	
Scenario: TC_KeywordSearch_08 : Search for an Mnemonic as "LVA.IPIMFG.RLVOFLFI.MTSA"
Given User enters Mnemonic "LVA.IPIMFG.RLVOFLFI.MTSA"
Then  User should get Mnemonic search results in SSI window	

@MnemonicSearch 	
Scenario: TC_KeywordSearch_09 : Search for an Mnemonic as "LVA.IPIMQ.RLVOFLFI.MT"
Given User enters Mnemonic "LVA.IPIMQ.RLVOFLFI.MT"
Then  User should get Mnemonic search results in SSI window	