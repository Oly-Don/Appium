package com.set.appium;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	String orderid=String.valueOf((new Date()).getTime());
    	String body="<request><ownerUserId>2635083319</ownerUserId><ownerUserName>宝洁海外旗舰店1</ownerUserName><storeCode>STORE_11180270</storeCode><orderCode>LBXunique</orderCode><erpOrderCode>47623444905776984</erpOrderCode><orderType>201</orderType><userId>2635083319</userId><userName>宝洁海外旗舰店</userName><orderFlag>22</orderFlag><orderSource>201</orderSource><orderSourceType>tb</orderSourceType><orderCreateTime>2017-08-18 17:05:06</orderCreateTime><deliverRequirements><scheduleArriveTime>2017-08-23 00:00:00</scheduleArriveTime></deliverRequirements><operationRequireTime><scheduleStockOutTime>2017-08-19 19:00:00</scheduleStockOutTime></operationRequireTime><batchSendCtrlParam><totalOrderItemCount>1</totalOrderItemCount><distributeType>0</distributeType></batchSendCtrlParam><receiverInfo><receiverZipCode>316000</receiverZipCode><receiverCountry>CN</receiverCountry><receiverProvince>浙江省</receiverProvince><receiverCity>舟山市</receiverCity><receiverArea>定海区</receiverArea><receiveTown>临城街道</receiveTown><receiverAddress>临城东方润园13幢2单元</receiverAddress><receiverDivisionId>330902006</receiverDivisionId><receiverName>叶晨萌</receiverName><receiverMobile>15957064416</receiverMobile></receiverInfo><senderInfo><senderZipCode>511458</senderZipCode><senderCountry>CN</senderCountry><senderProvince>广东省</senderProvince><senderCity>广州市</senderCity><senderArea>南沙区</senderArea><senderAddress>龙穴岛保税物流园区港荣三街”天运南沙多功能国际物流中心“7号仓</senderAddress><senderDivisionId>440115</senderDivisionId><senderName>客服中心</senderName><senderMobile>13068685892</senderMobile><senderPhone>020-62262358</senderPhone></senderInfo><invoiceInfoList/><orderItemList><orderItem><orderItemId>433190002879944508</orderItemId><orderSourceCode>47623444905776984</orderSourceCode><subSourceCode>47623444905776984</subSourceCode><userId>2635083319</userId><userName>宝洁海外旗舰店</userName><ownerUserId>2635083319</ownerUserId><ownerUserName>宝洁海外旗舰店</ownerUserName><itemId>536981055449</itemId><itemName>佳洁士3D闪耀炫白牙贴密集专效南沙保税</itemName><itemCode>80277488</itemCode><inventoryType>1</inventoryType><itemQuantity>1</itemQuantity><actualPrice>16694</actualPrice><itemPrice>47800</itemPrice><itemVersion>326</itemVersion><extendFields>actualValue:16694;seller_user_id:2635083319;ipm_index:231910127752230;extOrderItemId:113859535536;seller_user_nick:宝洁海外旗舰店;</extendFields></orderItem></orderItemList><extendFields>biz_order_code:47623444905776984;totalAmount:18800;orderItemCount:1;scheduleStockOutTime:20170819190000;operateType:1;scheduleArriveTime:2017/08/23;lgType:5;LP_CODE:LPunique;</extendFields><bizType>20</bizType></request>".replaceAll("order", orderid);
    	//放置请求参数
    	String[] msg_type = new String[] { "WMS_CONSIGN_ORDER_NOTIFY", "" };
Map<String ,String> vars=new HashMap<String ,String>();
    	vars.put("msg_type",msg_type[0]);//xml
    	vars.put("logistics_interface",body);//xml
/*
    	String mdStr=(new MD5()).test(body);
    	vars.put("data_digest",mdStr);//加密串  encodeing(body+""+123456)
    	log.info("------>"+vars.get("orderid"));*/
    }
}
