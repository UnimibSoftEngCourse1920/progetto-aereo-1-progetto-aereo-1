export class FlightList {
  constructor(
    public id: number,
    public posti: number,
    public LP: string, //luogo partenza
    public LA: string, //luogo arrivo
    public DP: string, //data partenza (non ho trovato costruttore data
    public OP: string, //orario partenza
    public state: boolean //Vero in attesa (mostrare), Falso effettuato/cancellato (non mostrare)
  ) { }
}
