package com.example.healthcareproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr Nokuthula Makhanya", "Hospital Address : Greytown", "Exp : 2 yrs", "Tel No : 0334139100", "600"},
                    {"Doctor Name : Dr Sesethu Makhanya", "Hospital Address : Durban", "Exp : 3 yrs", "Tel No : 0312345657", "300"},
                    {"Doctor Name : Dr Lwandle Zakwe", "Hospital Address : Johannesburg", "Exp : 5 yrs", "Tel No : 0330987655", "500"},
                    {"Doctor Name : Dr Peter Parker", "Hospital Address : California", "Exp : 10 yrs", "Tel No : 0765325678", "500"},
                    {"Doctor Name : Dr John Smith", "Hospital Address : Cape Town", "Exp : 7 yrs", "Tel No : 0331234567", "550"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dr Jabu Ndlovu", "Hospital Address : Muden", "Exp : 15 yrs", "Tel No : 0316786543", "800"},
                    {"Doctor Name : Dr Tom Jerry", "Hospital Address : Pretoria", "Exp : 3 yrs", "Tel No : 0865437890", "250"},
                    {"Doctor Name : Dr Dora Explorer", "Hospital Address : Pietermaritzburg", "Exp : 10 yrs", "Tel No : 0331234567", "450"},
                    {"Doctor Name : Dr Spider Man", "Hospital Address : Chicago", "Exp : 7 yrs", "Tel No : 0987654321", "300"},
                    {"Doctor Name : Dr Bat Man", "Hospital Address : Black", "Exp : 20 yrs", "Tel No : 03450931", "150"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr Mickey Mouse", "Hospital Address : Cartoons", "Exp : 8 yrs", "Tel No : 0985642411", "600"},
                    {"Doctor Name : Dr Minnie Mouse", "Hospital Address : Cartoons22", "Exp : 5 yrs", "Tel No : 0337685437", "300"},
                    {"Doctor Name : Dr Super Man", "Hospital Address : Washington", "Exp : 2 yrs", "Tel No : 0213456788", "500"},
                    {"Doctor Name : Dr John Cena", "Hospital Address : Washington DC", "Exp : 25 yrs", "Tel No : 0765325678", "350"},
                    {"Doctor Name : Dr Roman Reigns", "Hospital Address : Cape Town", "Exp : 10 yrs", "Tel No : 0331234567", "550"},
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr Chris Bernard", "Hospital Address : Cape Town", "Exp : 5 yrs", "Tel No : 0334139100", "450"},
                    {"Doctor Name : Dr Haroon Abassi", "Hospital Address : Brenthurst Hospital", "Exp : 4 yrs", "Tel No : 0116422776", "776"},
                    {"Doctor Name : Dr Osman Aboo", "Hospital Address : Medical South", "Exp : 5 yrs", "Tel No : 0317029393", "500"},
                    {"Doctor Name : Dr Olusola Adedipe", "Hospital Address : 21 Dane Street , Midrand, 1685", "Exp : 10 yrs", "Tel No : 0119221560", "350"},
                    {"Doctor Name : Dr Sumaya Ahmed", "Hospital Address : 4 Parklane Parktown Johannesburg 2193", "Exp : 7 yrs", "Tel No : 0114849120", "550"},
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr Ehi Aigbe", "Hospital Address : 1 Hospital Road, Randfontein, Gauteng, 1760", "Exp : 2 yrs", "Tel No : 0112788708", "600"},
                    {"Doctor Name : Dr Kamogelo Afrika", "Hospital Address : Life Anncron Hospital ", "Exp : 3 yrs", "Tel No : 0184680046", "300"},
                    {"Doctor Name : Dr Johan Aikman", "Hospital Address : Consortium Building, Suite 12", "Exp : 5 yrs", "Tel No : 0128074421", "500"},
                    {"Doctor Name : Dr Wesley M. Aitchison", "Hospital Address : Life Wilgeheuwel Hospital", "Exp : 10 yrs", "Tel No : 0117966781", "475"},
                    {"Doctor Name : Dr Tapeshwar Ajodha", "Hospital Address : Life Brenthurst Hospital, 4 Parklane", "Exp : 7 yrs", "Tel No : 0116479152", "550"},
            };
    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLTBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );

        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);

            }
        });

    }
}