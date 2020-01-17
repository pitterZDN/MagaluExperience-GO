package com.pedro.mex20;

import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.sceneform.ux.ArFragment;


public class customArFragment extends ArFragment {

    @Override
    protected Config getSessionConfiguration(Session session) {
        Config config = new Config(session);
        config.setPlaneFindingMode(Config.PlaneFindingMode.HORIZONTAL);
        config.setFocusMode(Config.FocusMode.AUTO);
        getArSceneView().setupSession(session);

        return config;
    }

}
