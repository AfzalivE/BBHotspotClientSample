package anajam.sample.hotspotclient;

import net.rim.device.api.system.ApplicationDescriptor;
import net.rim.device.api.system.WLANInfo;
import net.rim.device.api.system.WLANInfo.WLANAPInfo;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.wlan.hotspot.HotspotClient;
import net.rim.device.api.wlan.hotspot.HotspotClientRegistry;
import net.rim.device.api.wlan.hotspot.HotspotCredentialsAgent;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class HCScreen extends MainScreen
{
    /**
     * Creates a new HCScreen object
     */
    public HCScreen()
    {
        // Set the displayed title of the screen
        setTitle("Hotspot Client Sample");
        WLANAPInfo info = WLANInfo.getAPInfo();
        if (info == null) {
            MyHotspotAuthAgent hotSpotAuthAgent = new MyHotspotAuthAgent();
            MyHotspotClient hotSpotClient = new MyHotspotClient(HotspotCredentialsAgent.getSystemHotspotCredentialsAgent(), hotSpotAuthAgent, HotspotClient.NETWORK_TYPE_AUTOMATIC);
            HotspotClientRegistry.add(hotSpotClient, ApplicationDescriptor.currentApplicationDescriptor());
        } else if (info.getSSID() != "Default WLAN Network"){
            MyHotspotAuthAgent hotSpotAuthAgent = new MyHotspotAuthAgent();
            MyHotspotClient hotSpotClient = new MyHotspotClient(HotspotCredentialsAgent.getSystemHotspotCredentialsAgent(), hotSpotAuthAgent, HotspotClient.NETWORK_TYPE_AUTOMATIC);
            HotspotClientRegistry.add(hotSpotClient, ApplicationDescriptor.currentApplicationDescriptor());
        }
    }
}
