public class Komputer {
    String jenis_komputer;        
    private String merk;          

    public void setDataKomputer(String jenis, String merk){   
        jenis_komputer = jenis;                                
        this.merk = merk;                                      
    }                                                          

    public String getJenis(){
        return jenis_komputer;    
    }

    public String getMerk(){
        return merk;              
    }

    public static void main(String[]args){
        Komputer mykom = new Komputer();             
        mykom.setDataKomputer("LAPTOP", "MACBOOK");  
        System.out.println(mykom.getJenis());        
        System.out.println(mykom.getMerk());       
    }
}
