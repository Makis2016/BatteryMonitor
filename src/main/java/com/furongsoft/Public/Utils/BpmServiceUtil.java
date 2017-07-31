package com.furongsoft.Public.Utils;

import com.furongsoft.XspWeb.Common.Tracker;
import org.tempuri.BpmDataService;
import org.tempuri.IBPMWebInterface;

/**
 * Created by Linyudui on 2016/7/1.
 */
public class BpmServiceUtil
{
    private static BpmDataService sBpmDataService;
    private static IBPMWebInterface sIBpmDataService;

    public static synchronized BpmDataService GetBpmDataServiceInstance()
    {
        try {
            BpmDataService service = new BpmDataService();

            if (sBpmDataService != null)
                return sBpmDataService;
            else
                sBpmDataService = service;

            if (sIBpmDataService == null)
                sIBpmDataService = sBpmDataService
                    .getBasicHttpBindingIBPMWebInterface();

            return sBpmDataService;
        }
        catch (Throwable e) {
            Tracker.e(e.getMessage());
            sBpmDataService = null;
            sIBpmDataService = null;
            return null;
        }
    }

    public static synchronized IBPMWebInterface GetService()
    {
        GetBpmDataServiceInstance();

        return sIBpmDataService;
    }
}