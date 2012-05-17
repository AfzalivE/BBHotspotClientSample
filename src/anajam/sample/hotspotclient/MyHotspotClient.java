package anajam.sample.hotspotclient;

import net.rim.device.api.system.WLANInfo;
import net.rim.device.api.system.WLANInfo.WLANAPInfo;
import net.rim.device.api.wlan.hotspot.HotspotClient;
import net.rim.device.api.wlan.hotspot.HotspotCredentialsAgent;
import net.rim.device.api.wlan.hotspot.HotspotException;
import net.rim.device.api.wlan.hotspot.HotspotInfo;

public class MyHotspotClient extends HotspotClient {

    public MyHotspotClient(HotspotCredentialsAgent credentials,MyHotspotAuthAgent authentication,int networkType) throws IllegalArgumentException {
        super(credentials, authentication, networkType);
    }

    public String getClientName() {
        return "Default WLAN Network";
    }

    public HotspotInfo[] getSupportedNetworks(WLANAPInfo[] networks)
            throws HotspotException {
        HotspotInfo[] infos = new HotspotInfo[1];
        WLANAPInfo network = getOpenHotSpotInfo(networks[0]);
        HotspotInfo info = new HotspotInfo(network, true);
        infos[0] = info;
        System.out.println(infos[0].getStringProperty(HotspotInfo.PROPERTY_SSID));
        return infos;
    }

 public WLANAPInfo getOpenHotSpotInfo(WLANInfo.WLANAPInfo wLanInfo) {
        System.out.println("HotspotClient class************getHotSpotInfo()");
        StringBuffer wLanInfoBuff = new StringBuffer();
        String ssid = "";
        if(wLanInfo != null && wLanInfo.getSecurityCategory() == WLANAPInfo.SECURITY_CATEGORY_OPEN) {
            ssid = wLanInfo.getSSID();
            wLanInfoBuff.append("**SSID*****"+ssid.toString());
            wLanInfoBuff.append("**SecurityCategory*****"+wLanInfo.getSecurityCategory());
            System.out.println("HotspotClient class************getHotSpotInfo()"+wLanInfoBuff.toString());
            return wLanInfo;
        }
        return null;
    }
}
