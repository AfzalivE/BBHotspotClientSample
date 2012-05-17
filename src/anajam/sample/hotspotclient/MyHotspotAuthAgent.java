package anajam.sample.hotspotclient;

import net.rim.device.api.wlan.hotspot.HotspotAuthenticationAgent;
import net.rim.device.api.wlan.hotspot.HotspotInfo;

public class MyHotspotAuthAgent extends HotspotAuthenticationAgent {

    private int myState;

    public void cancelLogin(HotspotInfo hotspot) {
        myState = HotspotAuthenticationAgent.STATE_CANCELLING_LOGIN;
    }

    public int getSessionState() {
        return myState;
    }

    public void login(HotspotInfo hotspot) {
        myState = HotspotAuthenticationAgent.STATE_LOGGING_IN;
    }

    public void logout(HotspotInfo hotspot) {
        myState = HotspotAuthenticationAgent.STATE_LOGGING_OUT;
    }

}
