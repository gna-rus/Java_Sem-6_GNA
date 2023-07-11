public class NoteBookClass {

    private String AllName; // полное название ноутбука
    private String OpSys; // назвение и версия операционной системы
    private String color; // цвет ноутбука
    private int RAM; // обьем ОЗУ
    private int Hd; // обьем жесткого диска
    private double weight; // вес ноутбука
    private double price; // цена ноутбука

    //для домашних котов
   public NoteBookClass (String  AllName, String  OpSys, String  color, int RAM,
			int Hd, double weight, double price)
  {
    this.AllName = AllName;
    this.OpSys = OpSys;
    this.color = color;
    this.RAM = RAM;
    this.Hd = Hd;
    this.weight = weight;
    this.price = price;
  }
  
  public String GetAllName ()
  {
    return AllName;
  }

  public void SetAllName (String AllName)
  {
    this.AllName = AllName;
  }
  
  ////
  public String GetOpSys ()
  {
    return OpSys;
  }

  public void SetOpSys (String OpSys)
  {
    this.OpSys = OpSys;
  }
  ////
  
  public String getColor()
  {
    return color;
  }
  
  public void setColor (String color)
  {
    this.color = color;
  }
  ////
  
   public int getRAM()
  {
    return RAM;
  }
  
  public void setRAM (int RAM)
  {
    this.RAM = RAM;
  }
  ////
  
  public int getHd()
  {
    return Hd;
  }
  
  public void setHd (int Hd)
  {
    this.Hd = Hd;
  }
  ////
  
  public double getWeight()
  {
    return weight;
  }
  
  public void setWeight (double weight)
  {
    this.weight = weight;
  }
  ////
  
  public double getPrice()
  {
    return price;
  }
  
  public void setPrice (double price)
  {
    this.price = price;
  }  
    
    public NoteBookClass() {
        System.out.println("Неверный запрос");
    }
    
    @Override
    public String toString() {
      String weightF = String.format("%.2f", weight);
      String priceF = String.format("%.2f", price);
        return "NoteBookClass{"
                + "AllName = '" + AllName + '\''
                + ", OpSys = " + OpSys
                + ", color = " + color
                + ", RAM=" + RAM
                + ", Hd=" + Hd
                + ", weight=" + weightF
                + ", price=" + priceF
                + '}';
    }

    
}
