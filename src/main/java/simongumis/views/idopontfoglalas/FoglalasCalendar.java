package simongumis.views.idopontfoglalas;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import simongumis.config.MagyarDatum;
import simongumis.entities.IdopontfoglalasEntity;
import simongumis.entities.UgyfelEntity;
import simongumis.services.IdopontfoglalasService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;

@JsModule("@vaadin/vaadin-lumo-styles/badge.js")
@CssImport(value = "./styles/calendar.css", include = "lumo-badge")
public class FoglalasCalendar extends VerticalLayout {

    private final static Logger LOGGER = Logger.getLogger(FoglalasCalendar.class.getName());

    private IdopontfoglalasService idopontfoglalasService;
    private HorizontalLayout calendar;
    private HorizontalLayout fejlec;
    private Button buttonDatePicker;
    private Dialog ugyfelAdatok;
    private LocalDate aktualisCalendarDatum;
    private List<LocalDateTime> lefoglaltIdopontok;

    public FoglalasCalendar(IdopontfoglalasService idopontfoglalasService){
        this.idopontfoglalasService = idopontfoglalasService;
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        createFejlec();
        add(fejlec);

        aktualisCalendarDatum = LocalDate.now();
        createCalendar(aktualisCalendarDatum);
        add(calendar);
    }

    private void createFejlec (){
        fejlec = new HorizontalLayout();
        fejlec.setId("calendar_fejlec");

        FormLayout temporalLayout = new FormLayout();
        temporalLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 2));

        Button buttonToday = new Button("Ma", e -> {
            aktualisCalendarDatum = LocalDate.now();
            calendraRefresh(aktualisCalendarDatum);
        });

        Button buttonPrevious = new Button("", VaadinIcon.ANGLE_LEFT.create(), e -> {
            if (aktualisCalendarDatum.minusWeeks(1).compareTo(LocalDate.now())<1){
                aktualisCalendarDatum = LocalDate.now();
            }else {
                aktualisCalendarDatum = aktualisCalendarDatum.minusWeeks(1);
            }
            calendraRefresh(aktualisCalendarDatum);
        });
        Button buttonNext = new Button("", VaadinIcon.ANGLE_RIGHT.create(), e -> {
            aktualisCalendarDatum = aktualisCalendarDatum.plusWeeks(1);
            calendraRefresh(aktualisCalendarDatum);
        });
        buttonNext.setIconAfterText(true);

        DatePicker gotoDate = new MagyarDatum();
        gotoDate.setMin(LocalDate.now());
        gotoDate.addValueChangeListener(event1 -> {
            aktualisCalendarDatum = event1.getValue();
            calendraRefresh(aktualisCalendarDatum);
        });
        gotoDate.getElement().getStyle().set("visibility", "hidden");
        gotoDate.getElement().getStyle().set("position", "fixed");
        gotoDate.setWidth("0px");
        gotoDate.setHeight("0px");
        gotoDate.setWeekNumbersVisible(true);
        buttonDatePicker = new Button(VaadinIcon.CALENDAR.create());
        buttonDatePicker.getElement().appendChild(gotoDate.getElement());
        buttonDatePicker.addClickListener(event -> gotoDate.open());

        HorizontalLayout temporalSelectorLayout = new HorizontalLayout();
        temporalSelectorLayout.add(buttonPrevious, buttonDatePicker, buttonNext, gotoDate);
        temporalSelectorLayout.setSpacing(false);

        fejlec.add(buttonToday, temporalSelectorLayout);
    }

    private void createCalendar(LocalDate day){
        calendar = new HorizontalLayout();
        lefoglaltIdopontok = idopontfoglalasService.keresesIdopontraHeti(LocalDateTime.of(aktualisCalendarDatum, LocalTime.of(0,0)));
        //lefoglalt idopontok 7 napra:
        //lefoglaltIdopontok.forEach((i) -> LOGGER.info("foglalt: " + i.toString()));
        for(int i=0;i<7;i++){
            calendar.add(createDay(day.plusDays(i)));
        }
    }

    private VerticalLayout createDay(LocalDate day){
        VerticalLayout newDay = new VerticalLayout();
        newDay.setAlignItems(Alignment.CENTER);

        int munkaidoKezdete = 7;
        int munkaidoVege = 17;

        Span cim = new Span(day.toString());
        newDay.add(cim);
        cim.setId("cim");
        if(day.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            munkaidoKezdete = 0;
            munkaidoVege = 0;
        }
        if(day.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
            munkaidoKezdete = 7;
            munkaidoVege = 12;
        }


        for(int i = munkaidoKezdete;i<munkaidoVege;i++){

            LocalDateTime idopont = LocalDateTime.of(day, LocalTime.of(i, 0));
            LocalDateTime idopont2 = LocalDateTime.of(day, LocalTime.of(i, 30));

            if (!lefoglaltIdopontok.contains(idopont)){
                LocalTime localTime = LocalTime.of(i, 0);
                Button ujSor = new Button(localTime.toString());
                ujSor.getElement().getThemeList().add("badge success");
                ujSor.addClickListener(e -> foglalas(idopont));
                ujSor.getElement().addEventListener("mouseover", e -> ujSor.setText("Lefoglal"));
                ujSor.getElement().addEventListener("mouseout", e -> ujSor.setText(localTime.toString()));
                newDay.add(ujSor);
            } else {
                Button ujSor = new Button("Foglalt");
                ujSor.setDisableOnClick(false);
                ujSor.getElement().getThemeList().add("badge error");
                newDay.add(ujSor);
            }

            if (!lefoglaltIdopontok.contains(idopont2)){
                LocalTime localTime = LocalTime.of(i, 30);
                Button ujSor = new Button(localTime.toString());
                ujSor.getElement().getThemeList().add("badge success");
                ujSor.addClickListener(e -> foglalas(idopont2));
                ujSor.getElement().addEventListener("mouseover", e -> ujSor.setText("Lefoglal"));
                ujSor.getElement().addEventListener("mouseout", e -> ujSor.setText(localTime.toString()));
                newDay.add(ujSor);
            } else {
                Button ujSor = new Button("Foglalt");
                ujSor.setDisableOnClick(false);
                ujSor.getElement().getThemeList().add("badge error");
                newDay.add(ujSor);
            }
        }

        return newDay;
    }

    private void foglalas(LocalDateTime idopont){

        //LOGGER.info("Foglalásba belépet");

        ugyfelAdatok = new Dialog();

        VerticalLayout adatok = new VerticalLayout();
        HorizontalLayout gombok = new HorizontalLayout();
        VerticalLayout mezok1 = new VerticalLayout();
        HorizontalLayout mezok2 = new HorizontalLayout();
        HorizontalLayout mezok3 = new HorizontalLayout();

        H2 cim = new H2("Ügyféladatok");
        H4 idopontCimke = new H4(idopont.toLocalDate().toString() + " - " + idopont.toLocalTime().toString());
        TextField nev = new TextField("Név");
        nev.isRequired();
        EmailField email = new EmailField("E-mail");
        email.setErrorMessage("Rossz e-mail cím");
        TextField tel = new TextField("Telefonszám");
        tel.isRequired();
        TextField megjegyzes = new TextField("Megjegyzés");

        Button ok = new Button("Lefoglal");
        ok.addClickListener(e -> idopontfoglalasMentese(idopont, nev.getValue(), tel.getValue(), email.getValue(), megjegyzes.getValue()));
        Button kilep = new Button("Mégse");
        kilep.addClickListener(e -> ugyfelAdatok.close());

        mezok1.add(cim, idopontCimke);
        mezok2.add(nev, email);
        mezok3.add(tel, megjegyzes);
        gombok.add(kilep, ok);
        adatok.setAlignItems(Alignment.END);
        adatok.add(mezok1, mezok2, mezok3, gombok);
        ugyfelAdatok.add(adatok);

        ugyfelAdatok.open();

    }

    private void idopontfoglalasMentese(LocalDateTime idopont, String nev, String tel, String email, String megjegyzes){
        try{
            UgyfelEntity ugyfelEntity = new UgyfelEntity(nev, tel, email);
            IdopontfoglalasEntity idopontfoglalasEntity = new IdopontfoglalasEntity(idopont, ugyfelEntity, megjegyzes);
            idopontfoglalasService.idopontLefoglalas(idopontfoglalasEntity);
            ugyfelAdatok.removeAll();
            ugyfelAdatok.close();
            ugyfelAdatok = new Dialog();
            calendraRefresh(aktualisCalendarDatum);
            VerticalLayout mezok = new VerticalLayout();
            Span uzenet = new Span("Siekres időpontfoglalás");
            Button ok = new Button("Bezárás");
            ok.addClickListener(e ->  ugyfelAdatok.close());
            mezok.add(uzenet, ok);
            ugyfelAdatok.add(mezok);
            ugyfelAdatok.open();

        }catch (Exception ex){
            ugyfelAdatok.removeAll();
            ugyfelAdatok.close();
            VerticalLayout mezok = new VerticalLayout();
            Span uzenet = new Span("Az időpontfoglalás sikertelen kérjük próbálja meg ismét");
            Button ok = new Button("Bezárás");
            ok.addClickListener(e -> ugyfelAdatok.close());
            mezok.add(uzenet, ok);
            ugyfelAdatok.add(mezok);
            ugyfelAdatok.open();
        }
    }

    private void calendraRefresh(LocalDate datum){
        calendar.removeAll();
        remove(calendar);
        createCalendar(datum);
        add(calendar);
    }


}
