package simongumis.config;

import com.vaadin.flow.component.datepicker.DatePicker;

import java.util.Arrays;

public class MagyarDatum extends DatePicker {

    public MagyarDatum(){
        this.setI18n(magyarDatumInit());
    }

    private DatePickerI18n magyarDatumInit(){
        DatePickerI18n magyarDatum = new DatePickerI18n();
        magyarDatum.setCalendar("Kalendárium");
        magyarDatum.setCancel("Mégse");
        magyarDatum.setClear("Ürít");
        magyarDatum.setFirstDayOfWeek(1);
        String[] honap = {"Január", "Február", "Március", "Április", "Május", "Június", "Július", "Augusztus", "Szeptember", "Október", "November", "December"};
        magyarDatum.setMonthNames(Arrays.asList(honap));
        magyarDatum.setToday("Ma");
        magyarDatum.setWeek("Hét");
        String[] nap = {"Vasárnap", "Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat"};
        magyarDatum.setWeekdays(Arrays.asList(nap));
        String[] napRov = {"Va", "Hé", "Ke", "Sze", "Csü", "Pé", "Szo"};
        magyarDatum.setWeekdaysShort(Arrays.asList(napRov));
        return magyarDatum;
    }
}
