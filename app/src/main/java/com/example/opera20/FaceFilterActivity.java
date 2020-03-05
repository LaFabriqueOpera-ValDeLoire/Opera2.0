package com.example.opera20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.PixelCopy;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.AugmentedFace;
import com.google.ar.core.TrackingState;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.Camera;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.Sun;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.Texture;
import com.google.ar.sceneform.ux.AugmentedFaceNode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FaceFilterActivity extends AppCompatActivity {

    //implements PopupMenu.OnMenuItemClickListener
    private static final String TAG = FaceFilterActivity.class.getSimpleName();

    private static final double MIN_OPENGL_VERSION = 3.0;

    private FaceArFragment arFragment;//fragment dans lequel on applique l'api arCore;
    private ModelRenderable faceRegionsRenderable;//texture 3d integrant la partie haute du visage (chapeau par exemple);
    private Texture faceMeshTexture;//texture pour le filtre à appliquer sur le visage;
    private ImageView m_button_takePicture;//bouton pour prendre en photo;
    private ImageButton m_button_choix_filtres;
    ArSceneView sceneView;
    Scene scene;
    AugmentedFaceNode faceNode;
    int m_changement_filtre=0;//variable qui sera incrémentée pour permettre de changer les filtres de visage;

    private HashMap<AugmentedFace, AugmentedFaceNode> faceNodeMap = new HashMap<>();

    private AlphaAnimation buttonAnimationClick = new AlphaAnimation(1F, 0.8F);//pour animer le bouton lorsque l'on clique dessus;

    private ImageView m_image_backtopageaccueil;

    @Override
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    // CompletableFuture requires api level 24
    // FutureReturnValueIgnored is not valid
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        if (!checkIsSupportedDeviceOrFinish(this)) {
            return;
        }
        setContentView(R.layout.activity_face_filter);

        //Création de la scène de réalité augmentée sur le visage
        arFragment = (FaceArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);
        // Load the face mesh texture.
        Texture.builder()
                .setSource(this, R.drawable.homme)
                .build()
                .thenAccept(texture -> faceMeshTexture = texture);
        sceneView = arFragment.getArSceneView();
        // This is important to make sure that the camera stream renders first so that
        // the face mesh occlusion works correctly.
        sceneView.setCameraStreamRenderPriority(Renderable.RENDER_PRIORITY_FIRST);
        scene = sceneView.getScene();
        creationSceneFiltreVisage();

        m_button_choix_filtres=(ImageButton) findViewById(R.id.imageButtonChangeFilter);
        m_button_choix_filtres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m_changement_filtre+=1;
                // First face mask
                if( m_changement_filtre==1 )
                {
                    faceNodeMap.clear();
                    try{
                        faceNode.setParent(null);
                    }
                    catch (Exception e){ }

                    Texture.builder()
                            .setSource(FaceFilterActivity.this, R.drawable.traviataloup)
                            .build()
                            .thenAccept(texture -> faceMeshTexture = texture);
                }

                // Second face mask
                else  if(m_changement_filtre == 2)
                {
                    faceNodeMap.clear();
                    try{
                        faceNode.setParent(null);
                    }
                    catch (Exception e){ }
                    Texture.builder()
                            .setSource(FaceFilterActivity.this, R.drawable.violetta)
                            .build()
                            .thenAccept(texture -> faceMeshTexture = texture);
                }

                // Third face mask
                else  if( m_changement_filtre == 3 )
                {
                    faceNodeMap.clear();
                    try{
                        faceNode.setParent(null);
                    }
                    catch (Exception e){ }
                    Texture.builder()
                            .setSource(FaceFilterActivity.this, R.drawable.filtre_visage_creation_perso)
                            .build()
                            .thenAccept(texture -> faceMeshTexture = texture);
                }
                // Fourth face mask
                else  if( m_changement_filtre == 4 )
                {
                    faceNodeMap.clear();
                    try{
                        faceNode.setParent(null);
                    }
                    catch (Exception e){ }
                    Texture.builder()
                            .setSource(FaceFilterActivity.this, R.drawable.homme)
                            .build()
                            .thenAccept(texture -> faceMeshTexture = texture);
                    m_changement_filtre=0;//On remet la variable à 0 pour relancer la boucle au prochain appui du bouton
                }
            }
        });

        //Bouton pour prendre une photo
        m_button_takePicture=(ImageView) findViewById(R.id.imageViewPhoto);
        m_button_takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                takePhoto();
            }
        });

        //Bouton pour revenir à la page d'accueil
        m_image_backtopageaccueil=(ImageView) findViewById(R.id.backtopageaccueil);
        m_image_backtopageaccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonAnimationClick);//animation du bouton;
                Intent Latechnique = new Intent(FaceFilterActivity.this, PageAccueil.class);
                startActivity(Latechnique);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//transition entre les fenêtres;
                FaceFilterActivity.this.finish();
            }
        });
    }


    /*
    //Gérer la fenêtre popup pour pouvoir choisir le filtre:
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                faceNodeMap.clear();
                try{
                    faceNode.setParent(null);
                }
                catch (Exception e){

                }

                // Load the face mesh texture.
                Texture.builder()
                        .setSource(this, R.drawable.homme)
                        .build()
                        .thenAccept(texture -> faceMeshTexture = texture);
                Toast.makeText(this, "Masque du Marquis", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                faceNodeMap.clear();
                try{
                    faceNode.setParent(null);
                }
                catch (Exception e){

                }

                // Load the face mesh texture.
                Texture.builder()
                        .setSource(this, R.drawable.traviataloup)
                        .build()
                        .thenAccept(texture -> faceMeshTexture = texture);

                Toast.makeText(this, "Masque Traviata", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                faceNodeMap.clear();
                try{
                    faceNode.setParent(null);
                }
                catch (Exception e){

                }

                // Load the face mesh texture.
                Texture.builder()
                        .setSource(this, R.drawable.violetta)
                        .build()
                        .thenAccept(texture -> faceMeshTexture = texture);
                Toast.makeText(this, "Masque Violetta", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }
    */

    //Creation de la scene pour afficher le filtre:
    private void creationSceneFiltreVisage(){
        /*ArSceneView sceneView = arFragment.getArSceneView();

        // This is important to make sure that the camera stream renders first so that
        // the face mesh occlusion works correctly.
        sceneView.setCameraStreamRenderPriority(Renderable.RENDER_PRIORITY_FIRST);

        Scene scene = sceneView.getScene();*/
        scene.addOnUpdateListener(
                (FrameTime frameTime) -> {
                    if (/*faceRegionsRenderable == null ||*/ faceMeshTexture == null) {
                        return;
                    }

                    Collection<AugmentedFace> faceList =
                            sceneView.getSession().getAllTrackables(AugmentedFace.class);

                    // Make new AugmentedFaceNodes for any new faces.
                    for (AugmentedFace face : faceList) {
                        if (!faceNodeMap.containsKey(face)) {
                            faceNode = new AugmentedFaceNode(face);
                            faceNode.setParent(scene);
                            faceNode.setFaceRegionsRenderable(faceRegionsRenderable);
                            faceNode.setFaceMeshTexture(faceMeshTexture);
                            faceNodeMap.put(face, faceNode);
                        }
                    }

                    // Remove any AugmentedFaceNodes associated with an AugmentedFace that stopped tracking.
                    Iterator<Map.Entry<AugmentedFace, AugmentedFaceNode>> iter =
                            faceNodeMap.entrySet().iterator();
                    while (iter.hasNext()) {
                        Map.Entry<AugmentedFace, AugmentedFaceNode> entry = iter.next();
                        AugmentedFace face = entry.getKey();
                        if (face.getTrackingState() == TrackingState.STOPPED) {
                            AugmentedFaceNode faceNode = entry.getValue();
                            faceNode.setParent(null);
                            iter.remove();
                        }
                    }
                });
    }



    private String generateFilename() {
        String date =
                new SimpleDateFormat("yyyyMMddHHmmss", java.util.Locale.getDefault()).format(new Date());
        return Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES) + File.separator + "Opera2.0/" + date + "_screenshot.jpg";
    }

    private void saveBitmapToDisk(Bitmap bitmap, String filename) throws IOException {

        File out = new File(filename);
        if (!out.getParentFile().exists()) {
            out.getParentFile().mkdirs();
        }
        try (FileOutputStream outputStream = new FileOutputStream(filename);
             ByteArrayOutputStream outputData = new ByteArrayOutputStream()) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputData);
            outputData.writeTo(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            throw new IOException("Failed to save bitmap to disk", ex);
        }
    }

    private void takePhoto() {
        final String filename = generateFilename();
        ArSceneView view = arFragment.getArSceneView();

        // Create a bitmap the size of the scene view.
        final Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),
                Bitmap.Config.ARGB_8888);

        // Create a handler thread to offload the processing of the image.
        final HandlerThread handlerThread = new HandlerThread("PixelCopier");
        handlerThread.start();
        // Make the request to copy.
        PixelCopy.request(view, bitmap, (copyResult) -> {
            if (copyResult == PixelCopy.SUCCESS) {
                try {
                    saveBitmapToDisk(bitmap, filename);
                } catch (IOException e) {
                    Toast toast = Toast.makeText(FaceFilterActivity.this, e.toString(),
                            Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                        "Photo saved", Snackbar.LENGTH_LONG);
                snackbar.setAction("Open in Photos", v -> {
                    File photoFile = new File(filename);

                    Uri photoURI = FileProvider.getUriForFile(FaceFilterActivity.this,
                            FaceFilterActivity.this.getPackageName() + ".ar.codelab.name.provider",
                            photoFile);
                    Intent intent = new Intent(Intent.ACTION_VIEW, photoURI);
                    intent.setDataAndType(photoURI, "image/*");
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent);

                });
                snackbar.show();
            } else {
                Toast toast = Toast.makeText(FaceFilterActivity.this,
                        "Failed to copyPixels: " + copyResult, Toast.LENGTH_LONG);
                toast.show();
            }
            handlerThread.quitSafely();
        }, new Handler(handlerThread.getLooper()));
    }









    /**
     * Returns false and displays an error message if Sceneform can not run, true if Sceneform can run
     * on this device.
     *
     * <p>Sceneform requires Android N on the device as well as OpenGL 3.0 capabilities.
     *
     * <p>Finishes the activity if Sceneform can not run
     */
    public static boolean checkIsSupportedDeviceOrFinish(final Activity activity) {
        if (ArCoreApk.getInstance().checkAvailability(activity)
                == ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE) {
            Log.e(TAG, "Augmented Faces requires ARCore.");
            Toast.makeText(activity, "Augmented Faces requires ARCore", Toast.LENGTH_LONG).show();
            activity.finish();
            return false;
        }
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }



    //To destroy the activity if the user clicks on the back button;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent HomePage2 = new Intent(FaceFilterActivity.this, PageAccueil.class);
            startActivity(HomePage2);
            FaceFilterActivity.this.finish();
        }
        return false;
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
