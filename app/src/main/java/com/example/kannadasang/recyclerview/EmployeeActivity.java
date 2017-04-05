package com.example.kannadasang.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class EmployeeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Employee> employees=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_employee);
        setTitle("Employee List");
        setEmployeeList();
        recyclerView=(RecyclerView) findViewById(R.id.empRecycler);

        LinearLayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        EmployeeAdapter empAdapter= new EmployeeAdapter(employees);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(empAdapter);

    }
    private void setEmployeeList()
    {
        // Read xml and fill employee details in Employee object list
        try {
            InputStream is = getResources().openRawResource(R.raw.employees);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element=doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("employee");

            for (int i=0; i<nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element2 = (Element) node;
                    employees.add(new Employee(getElementValue("Name", element2),
                            getElementValue("Designation", element2),
                            getElementValue("Gender", element2),getElementValue("Year", element2)));
                }
            }

        } catch (Exception e) {e.printStackTrace();}
    }
    private static String getElementValue(String tag, Element element) {
        NodeList mNodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = mNodeList.item(0);
        return node.getNodeValue();
    }
}
