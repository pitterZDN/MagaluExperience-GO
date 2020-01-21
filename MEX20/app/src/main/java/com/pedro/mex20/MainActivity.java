package com.pedro.mex20;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.assets.RenderableSource;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity {

    private ArFragment arFragment; //Recupera o ArFragment.
    private String ASSET_3D = "https://storage.googleapis.com/squad-vendas-ar/001/boxwood_plant.gltf"; //Link do modelo em GLTF2.
    private int count = 0; //Contador de modelos já em cena.
    private TransformableNode model; //Modelo final com característica de transformação.
    private ModelRenderable modelRenderable; //Modelo renderizado bruto.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicia uma cena de realidade aumentada.
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.uxFragment);
        loadModel();

        //Identifica em qual localização do plano encontrado foi clicado.
        //Cria ancora no local onde foi clicado.
        arFragment.setOnTapArPlaneListener(((hitResult, plane, motionEvent) -> {
            addNodeToScreen(hitResult.createAnchor());
        }));

    }


    //Carrega o modelo 3D atráves do ASSET_3D em RUNTIME no tip GLTF2.
    private void loadModel() {

        ModelRenderable
                .builder()
                .setSource(
                        this,
                        RenderableSource
                        .builder()
                        .setSource(this, Uri.parse(ASSET_3D), RenderableSource.SourceType.GLTF2)
                        .setRecenterMode(RenderableSource.RecenterMode.ROOT)
                        .build()
                )
                .setRegistryId(ASSET_3D)
                .build()
                .thenAccept(renderable -> modelRenderable = renderable)
                .exceptionally(throwable -> {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(throwable.getMessage()).show();
                    return null;
                });

    }

    //Leva o modelo até a localização da ancora
    private void addNodeToScreen(Anchor anchor) {
        AnchorNode anchorNode = new AnchorNode(anchor);

        arFragment.getArSceneView().getScene().addChild(anchorNode);

        if(count < 1) { //Verifica quantidade de modelo colocado na cena, caso seja maior ou igual a um, muda posição do atual.
            count++;
            model = new TransformableNode(arFragment.getTransformationSystem());
        }
        model.setParent(anchorNode);
//        model.getScaleController().setEnabled(false);
        model.setRenderable(modelRenderable);
        model.select();
    }
}
