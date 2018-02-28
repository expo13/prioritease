package expotek.com.prioritease;

import android.app.Application;
import android.content.res.Configuration;

import com.facebook.soloader.SoLoader;

public class PrioriTeaseApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}
