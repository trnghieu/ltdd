package com.example.customeadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    //khai báo
    ListView listView;
    ArrayList<MonHoc> arrayList;
    MonHocAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listview);

// Ánh xạ các View
        AnhXa();

        // Tạo Adapter
        adapter = new MonHocAdapter(ListViewActivity.this, R.layout.row_monhoc, arrayList);

        // Truyền dữ liệu từ adapter ra ListView
        listView.setAdapter(adapter);

        // Bắt sự kiện khi click vào item trong ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonHoc selectedMonHoc = arrayList.get(position);
                Toast.makeText(ListViewActivity.this, "Bạn chọn: " + selectedMonHoc.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                MonHoc selectedMonHoc = arrayList.get(position);
                Toast.makeText(ListViewActivity.this, "Bạn đang nhấn giữ "+ selectedMonHoc.getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    private void AnhXa() {
        listView = findViewById(R.id.listView);

        // Thêm dữ liệu vào danh sách
        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java", "Java 1", R.drawable.java));
        arrayList.add(new MonHoc("C#", "C# 1", R.drawable.c));
        arrayList.add(new MonHoc("PHP", "PHP 1", R.drawable.php));
        arrayList.add(new MonHoc("Kotlin", "Kotlin 1", R.drawable.kotlin));
        arrayList.add(new MonHoc("Dart", "Dart 1", R.drawable.dart));
    }

}
