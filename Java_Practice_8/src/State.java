public class State {

    public String Abbreve;
    public String State_name;
    public float rates;

    public State(String S_abbre, String S_name, float s_rates)
    {
        Abbreve = S_abbre;
        State_name = S_name;
        rates = s_rates;
    }

    public String getAbbreve()
    {
        return this.Abbreve;
    }

    public String getState_name()
    {
        return this.State_name;
    }

    public float getRates()
    {
        return this.rates;
    }






}
