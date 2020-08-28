# Communal-payments (v 2.0)
sending communal meters values to private consumer pages in web sites using Selenium API

<p> Electricity: https://info.loe.lviv.ua<p\>
<p> Gas: https://104.ua<p\>
<p> Water: https://infolviv.com.ua<p\>
<p> On system preferences you need indicate:

	- your email which you use as user name ('USER_EMAIL');
	- password for LOE (https://info.loe.lviv.ua) site ('LOE_SITE_PASSWORD');
	- private invoice for LOE site ('LOE_SITE_PRIVATE_INVOICE'). This number you find on the page (https://info.loe.lviv.ua/consumers/{your invoice}/info) as a part of URI;
	- password for INFO_LVIV (https://infolviv.com.ua) site ('INFO_LVIV_SITE_PASSWORD');
	- private invoice for INFO_LVIV site ('INFO_LVIV_SITE_WATER_PRIVATE_INVOICE'). This number you find on the page (https://infolviv.com.ua/dashboard/counters) as the 'Invoice' for the necessary meter;
	- password for 104UA (https://104.ua) site ('104UA_SITE_PASSWORD');
	- private invoice for 104UA site ('104UA_SITE_GAS_PRIVATE_INVOICE'). This number you find on the page (https://104.ua/ua/cabinet/info) as the 'private invoice N'. <p/>

<p>Also you need input your current meters values to file 'values.txt'.<p/>
<p>Warning! This version of the program, for sending electricity values, works with a 2-tariff electricity meter. If you need to enter only a one day value of electricity, in 'InputCommunalPayments' and 
'LOESiteTest' classes you need use 'UserRepository.get().userLOECredentialsOnlyDayValue()'.<p/>
