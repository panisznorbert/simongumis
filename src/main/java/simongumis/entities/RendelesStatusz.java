package simongumis.entities;

public enum RendelesStatusz {
    KOSARBAN, MEGRENDELVE, ATVETELRE_VAR, FIZETVE, TOROLVE;

    @Override
    public String toString() {
        switch(this){
            case MEGRENDELVE: return "Megrendelve";
            case ATVETELRE_VAR: return "Átvételre vár";
            case FIZETVE: return "Fizetve és átvéve";
            case TOROLVE: return "Törölve";
            default: return "Kosárban";
        }

    }
}
