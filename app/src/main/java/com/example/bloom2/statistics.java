package com.example.bloom2;
//This activity collects the data from the timer and makes a graph and lists sleeping statistics
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
//import 3rd party library to show demo data
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Begin adding data and both the x and y axis for the graph
        LineChartView lineChartView = findViewById(R.id.chart);
        String[] axisData = {"Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7"};
        int[] yAxisData = {10,8,12,7,5,8,9};
        //Declare lists
        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        //Edit the line chart and put the data in it
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#FFFFFF"));

        for(int i = 0; i < axisData.length; i++){
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++){
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        //Declare a list to hold the line of the list
        List lines = new ArrayList();
        lines.add(line);

        //input the line into the graph chart
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //make the line visible
        lineChartView.setLineChartData(data);

        //Make the axes visible on the activity
        Axis axis = new Axis();
        axis.setValues(axisValues);
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);

        //change colors and sizes of graph features
        axis.setTextSize(10);
        yAxis.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis.setTextSize(10);

        axis.setTextColor(Color.parseColor("#FFFFFF"));
        yAxis.setName("Points Earned in a Week");

        axis.setName("Number of Days");
    }

}