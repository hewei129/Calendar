package com.hw.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.hw.calendarlib.DatePickerController;
import com.hw.calendarlib.DayPickerView;
import com.hw.calendarlib.SimpleMonthAdapter;

import java.util.Calendar;
import java.util.List;

/**
 * @author hewei(David)
 * @date 2020/11/20  10:58 AM
 * @Copyright ©  Shanghai Xinke Digital Technology Co., Ltd.
 * @description
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month =  Calendar.getInstance().get(Calendar.MONTH) + 1;
        if (month - 11 > 0)
            dataModel.yearStart = year;
        else dataModel.yearStart = year - 1;
        dataModel.monthStart = month;
        dataModel.monthCount = 12;
        dataModel.leastDaysNum = 2;
        dataModel.mostDaysNum = 100;

        ((DayPickerView)findViewById(R.id.dpv_calendar)).setParameter(dataModel, new DatePickerController() {
            @Override
            public void onDayOfMonthSelected(SimpleMonthAdapter.CalendarDay calendarDay) {
                Toast.makeText(MainActivity.this, calendarDay.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDateRangeSelected(List<SimpleMonthAdapter.CalendarDay> selectedDays) {
//                Toast.makeText(MainActivity.this, selectedDays.get(0).toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void alertSelectedFail(FailEven even) {

            }
        });

    }
}
