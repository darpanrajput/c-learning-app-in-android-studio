package com.darpan.learnc;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.PurchaseInfo;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class DownloadActivity extends AppCompatActivity implements BillingProcessor.IBillingHandler {
    String publicKey ="Your google public Key";
    ProgressBar progressBar;
    TextView textView;
    Button button;
    StorageReference storageReference;
    StorageReference ref;
    FirebaseStorage firebaseStorage;
    PurchaseInfo transactionDetails;
    private ArrayList<String> urlList = new ArrayList<>();
    int arryIndex;
    /*  BillingClient billingClient;*/
    BillingProcessor bp;
    ArrayList<String> productIds = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        urlList.clear();
        productIds.clear();

        progressBar = findViewById(R.id.download_progres);
        textView = findViewById(R.id.Download_tv);
        button = findViewById(R.id.go_back);

        bp = new BillingProcessor(this, publicKey, this);
        bp.initialize();

        Intent intent = getIntent();
        arryIndex = intent.getIntExtra("index", 2) + 1;

        addProductIds();
        initUrlsThroughModals();
        setupBilling();
       //

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void addProductIds() {
        productIds.add("purchase_pdf_1");
        productIds.add("purchase_pdf_2");
        productIds.add("purchase_pdf_3");
        productIds.add("purchase_pdf_4");
        productIds.add("purchase_pdf_5");
        productIds.add("purchase_pdf_6");
        productIds.add("purchase_pdf_7");
        productIds.add("purchase_pdf_8");
        productIds.add("purchase_pdf_9");
        productIds.add("purchase_pdf_10");
    }


    private void download() {
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child(urlList.get(arryIndex));
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String URL = uri.toString();
                downloadfiles(DownloadActivity.this, urlList.get(arryIndex), ".pdf",
                        Environment.DIRECTORY_DOWNLOADS, URL);
//                relativeLayout.setVisibility(View.GONE);
                progressBar.setVisibility(View.INVISIBLE);
                button.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                textView.setText("Added to Download.You can Go back");

//                setupBilling();


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                /*  relativeLayout.setVisibility(View.GONE);*/
                Log.e("error1", e.getMessage());
                progressBar.setVisibility(View.INVISIBLE);
                button.setVisibility(View.VISIBLE);
                textView.setVisibility(View.VISIBLE);
                button.setText("Go back And Retry again");
                textView.setText("Something went wrong:Cause:" + e.getMessage());

            }
        });

    }

    private void setupBilling() {
        bp.purchase(DownloadActivity.this, productIds.get(arryIndex));

    }


    private void downloadfiles(Context context, String filename, String fileExtension,
                               String fileDestinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        request.setDestinationInExternalFilesDir(context, fileDestinationDirectory, filename + fileExtension);
        downloadManager.enqueue(request);
    }

    private void initUrlsThroughModals() {
        urlList.add("C Operators.pdf");
        urlList.add("C Branching Statements.pdf");

        urlList.add("C File Input_Output.pdf");
        urlList.add("C Jumping Statements.pdf");

        urlList.add("C Looping Statements.pdf");
        urlList.add("C Programming _ C Arrays.pdf");

        urlList.add("C Programming _ C Functions.pdf");
        urlList.add("C Programming _ C Pointers.pdf");

        urlList.add("C Programming _ C Strings.pdf");
        urlList.add("C Programming _ C Structures.pdf");

    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {
        download();
        Toast.makeText(this, "onProductPurchased", Toast.LENGTH_SHORT).show();
        transactionDetails = details.purchaseInfo;
        if (transactionDetails == null) {
            textView.setText("you have not purchased this item");
        } else {

            textView.setText("you have purchased this item" + details.purchaseInfo);
        }

        bp.consumePurchase(productIds.get(arryIndex));
    }

    @Override
    public void onPurchaseHistoryRestored() {
        Toast.makeText(this, "PurchaseHistoryRestored", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {
        Toast.makeText(this, "BillingError", Toast.LENGTH_SHORT).show();
        Log.i("billingError", error.getMessage());
    }

    @Override
    public void onBillingInitialized() {
        Toast.makeText(this, "BillingInitialized", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        if (bp != null) {
            bp.release();
        }
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
