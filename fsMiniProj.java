import java.io.*;
import java.util.*;
class fsMiniProj
{
    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException,NullPointerException
    {
        fsMiniProj obj = new fsMiniProj();
        int choice;
        while(true)
        {
            System.out.println("");
            System.out.println("**");
            System.out.println("1.Insert New Student record");
            System.out.println("2.View all Student records in a department");
            System.out.println("3.Search for a student record!!");
            System.out.println("4.Modify()");
            System.out.println("5.Exit");
            System.out.println("**");
            System.out.println("Please enter your choice:");
            choice = obj.scan.nextInt();
            obj.scan.nextLine();
            System.out.println("");
            switch(choice)
            {
                case 1:
                obj.pack();
                break;
                case 2:
                obj.unpack();
                break;
                case 3:
                obj.search();
                break;
                case 4:
                obj.modify();
                break;
                case 5:
                System.out.println("You chose exit!");
                System.exit(0);
                default:
                System.out.println("Invalid Option");
            }
        }
    }
 
    public void pack() throws FileNotFoundException
    {
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        System.out.print("Enter USN: ");
        String usn = scan.nextLine();
        System.out.print("Enter Phno: ");
        String phno = scan.nextLine();
        System.out.print("Enter Date of birth(dd/mm/yyyy): ");
        String dob = scan.nextLine();
        System.out.print("Enter year of studying: ");
        String year = scan.nextLine();
        System.out.print("Enter branch: ");
        String branch = scan.nextLine();
        String key= hashTable(branch,year);
        write(name,usn,phno,dob,key);    
    }
        
    public void unpack()throws IOException
    {
        String name = "" ,usn = "" ,phno= "" , dob=" ", s;
        System.out.println("Enter department");
        String branch = scan.nextLine();
        if(branch.equalsIgnoreCase("ise")){
        for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("ise/"+i+".txt"));
                System.out.println("Students of sem:"+i+"");
                    while((s = br.readLine())!=null)
                    {
                        String[] result = s.split("\\|");
                        usn = result[0];
                        name = result[1];
                        phno = result[2];
                        dob=result[3];
                        System.out.println("The details are: " + usn + " " + name + " " + phno + " " + dob );
                    }
                    br.close();
                
        }
       
    }
    if(branch.equalsIgnoreCase("cse")){
        for (int i=1;i<=4;i++){
        BufferedReader br = new BufferedReader(new FileReader("cse/"+i+".txt"));
        System.out.println("Students of sem:"+i+"");
        while((s = br.readLine())!=null)
        {
            String[] result = s.split("\\|");
                        usn = result[0];
                        name = result[1];
                        phno = result[2];
                        dob=result[3];
                        System.out.println("The details are: " + usn + " " + name + " " + phno + " " + dob );
        }
        br.close();
        }
       
    }
    if(branch.equalsIgnoreCase("tce")){
        for (int i=1;i<=4;i++){
        BufferedReader br = new BufferedReader(new FileReader("tce/"+i+".txt"));
        System.out.println("Students of sem:"+i+"");
        while((s = br.readLine())!=null)
        {
            String[] result = s.split("\\|");
                        usn = result[0];
                        name = result[1];
                        phno = result[2];
                        dob=result[3];
                        System.out.println("The details are: " + usn + " " + name + " " + phno + " " + dob );
        }
        br.close();
        }
       
    }
    if(branch.equalsIgnoreCase("ece")){
        for (int i=1;i<=4;i++){
        BufferedReader br = new BufferedReader(new FileReader("ece/"+i+".txt"));
        System.out.println("Students of sem:"+i+"");
        while((s = br.readLine())!=null)
        {
            String[] result = s.split("\\|");
            usn = result[0];
            name = result[1];
            phno = result[2];
            dob=result[3];
            System.out.println("The details are: " + usn + " " + name + " " + phno + " " + dob );
        }
        br.close();
        }
       
    }
}
      
    public void search()throws FileNotFoundException, IOException
    {

        String name = "", usn = "", phno="",dob="", r;
        System.out.print("Enter the usn of the student to search: ");
        String usn1 = scan.nextLine();
        int flag=0;
        if(usn1.contains("cs")){
            for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("cse/"+i+".txt"));
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found in year "+ i );
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: " + i + "\nbranch: CSE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            br.close();
                            flag=1;
                            return;
                        }
                    }
                    br.close();  
            }
            if(flag==0)
                        {
                            System.out.println("Record NOT found");
                            System.out.println(); 
                        }
        }
        if(usn1.contains("is")){
            for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("ise/"+i+".txt"));
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found in year "+ i );
                            System.out.println("The details of the record are:");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: " + i + "\nbranch: ISE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            br.close();
                            flag=1;
                            return;
                        }
                    }
                    br.close();
            }
            if(flag==0)
                        {
                            System.out.println("Record NOT found");
                            System.out.println(); 
                        }
        }
        if(usn1.contains("tc")){
            for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("tce/"+i+".txt"));
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found in year "+ i );
                            System.out.println("The details of the record are:");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: " + i + "\nbranch: TCE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            br.close();
                            flag=1;
                            return;
                        }
                    }
                        br.close(); 
            }
            if(flag==0)
            {
                System.out.println("Record NOT found");
                System.out.println();
            }
        }
        if(usn1.contains("ec")){
            for (int i=1;i<=4;i++){
                BufferedReader br = new BufferedReader(new FileReader("ece/"+i+".txt"));
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found in year "+ i );
                            System.out.println("The details of the record are:");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: " + i + "\nbranch: ECE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            br.close();
                            flag=1;
                            return;
                        }
                    }
                     br.close(); 
            }
            if(flag==0)
            {
                System.out.println("Record NOT found");
                System.out.println();
            }
        }
    }

    public void modify() throws FileNotFoundException,IOException,NullPointerException


    {
        String name = "", usn = "", dob = "", phno="",r;
        int flag=0;
        System.out.println("Enter usn");
        String usn1 = scan.nextLine();
        String v=hash1(usn1);
        if(usn1.contains("cs")){           
                File temp = new File("cse/temp.txt");
                PrintWriter pw = new PrintWriter(temp);
                File file = new File("cse/"+v+".txt");
                BufferedReader br = new BufferedReader(new FileReader(file));               
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: "+v  + "\nbranch: CSE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            System.out.print("enter Name: ");
                            String name11 = scan.nextLine();            
                            System.out.print("enter phno: ");
                            String phno11 = scan.nextLine();
                            System.out.print("enter dob: ");
                            String dob11 = scan.nextLine();
                            System.out.print("enter branch: ");
                            String branch11 = scan.nextLine();
                            if(!branch11.equalsIgnoreCase("CSE")){
                                System.out.print("enter USN: ");
                                String usn11 = scan.nextLine();
                                System.out.print("enter Year of Studying: ");
                                String year = scan.nextLine();
                                String key=hashTable(branch11,year);
                                write(name11,usn11,phno11,dob11,key);
                                flag=1;
                            }
                            if(flag!=1){
                                String b = usn + "|" + name11 + "|" + phno11 + "|" + dob11 + "|";
                                pw.println(b);
                                flag=1;
                            }
                        }
                        else {
                            pw.println(r);
                        }
                    
                  }  //while end
                    br.close();
                    pw.flush();
                    pw.close();
                    file.delete();
                    temp.renameTo(file);

                    //System.out.println("File Modified"); 
            }

            if(usn1.contains("is")){           
                File temp = new File("ise/temp.txt");
                PrintWriter pw = new PrintWriter(temp);
                File file = new File("ise/"+v+".txt");
                BufferedReader br = new BufferedReader(new FileReader(file));               
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: "+v  + "\nbranch: ISE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            System.out.print("enter Name: ");
                            String name11 = scan.nextLine();            
                            System.out.print("enter phno: ");
                            String phno11 = scan.nextLine();
                            System.out.print("enter dob: ");
                            String dob11 = scan.nextLine();
                            System.out.print("enter branch: ");
                            String branch11 = scan.nextLine();
                            if(!branch11.equalsIgnoreCase("ISE")){
                                System.out.print("enter USN: ");
                                String usn11 = scan.nextLine();
                                System.out.print("enter Year of Studying: ");
                                String year = scan.nextLine();
                                String key=hashTable(branch11,year);
                                write(name11,usn11,phno11,dob11,key);
                                flag=1;
                            }
                            if(flag!=1){
                                String b = usn + "|" + name11 + "|" + phno11 + "|" + dob11 + "|";
                                pw.println(b);
                                flag=1;
                            }
                        }
                        else {
                            pw.println(r);
                        }
                    
                  }  //while end
                    br.close();
                    pw.flush();
                    pw.close();
                    file.delete();
                    temp.renameTo(file);

                    //System.out.println("File Modified"); 
            }

            if(usn1.contains("tc")){           
                File temp = new File("tce/temp.txt");
                PrintWriter pw = new PrintWriter(temp);
                File file = new File("tce/"+v+".txt");
                BufferedReader br = new BufferedReader(new FileReader(file));               
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: "+v  + "\nbranch: TCE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            System.out.print("enter Name: ");
                            String name11 = scan.nextLine();            
                            System.out.print("enter phno: ");
                            String phno11 = scan.nextLine();
                            System.out.print("enter dob: ");
                            String dob11 = scan.nextLine();
                            System.out.print("enter branch: ");
                            String branch11 = scan.nextLine();
                            if(!branch11.equalsIgnoreCase("TCE")){
                                System.out.print("enter USN: ");
                                String usn11 = scan.nextLine();
                                System.out.print("enter Year of Studying: ");
                                String year = scan.nextLine();
                                String key=hashTable(branch11,year);
                                write(name11,usn11,phno11,dob11,key);
                                flag=1;
                            }
                            if(flag!=1){
                                String b = usn + "|" + name11 + "|" + phno11 + "|" + dob11 + "|";
                                pw.println(b);
                                flag=1;
                            }
                        }
                        else {
                            pw.println(r);
                        }
                    
                  }  //while end
                    br.close();
                    pw.flush();
                    pw.close();
                    file.delete();
                    temp.renameTo(file);

                    //System.out.println("File Modified"); 
            }

            if(usn1.contains("ec")){           
                File temp = new File("ece/temp.txt");
                PrintWriter pw = new PrintWriter(temp);
                File file = new File("ece/"+v+".txt");
                BufferedReader br = new BufferedReader(new FileReader(file));               
                while((r= br.readLine()) !=null)
                    {   
                        String[] result = r.split("\\|");
                        usn=result[0];
                        if(usn.equals(usn1))
                        {   
                            name=result[1];
                            phno= result[2];
                            dob=result[3];
                            System.out.println("Record found");
                            System.out.println("Name: "+ name + "\nusn: " + usn + "\nyear: "+v  + "\nbranch: TCE"+ "\nphno: " + phno + "\ndate of birth: " + dob);
                            System.out.print("enter Name: ");
                            String name11 = scan.nextLine();            
                            System.out.print("enter phno: ");
                            String phno11 = scan.nextLine();
                            System.out.print("enter dob: ");
                            String dob11 = scan.nextLine();
                            System.out.print("enter branch: ");
                            String branch11 = scan.nextLine();
                            if(!branch11.equalsIgnoreCase("ECE")){
                                System.out.print("enter USN: ");
                                String usn11 = scan.nextLine();
                                System.out.print("enter Year of Studying: ");
                                String year = scan.nextLine();
                                String key=hashTable(branch11,year);
                                write(name11,usn11,phno11,dob11,key);
                                flag=1;
                            }
                            if(flag!=1){
                                String b = usn + "|" + name11 + "|" + phno11 + "|" + dob11 + "|";
                                pw.println(b);
                                flag=1;
                            }
                        }
                        else {
                            pw.println(r);
                        }
                    
                  }  //while end
                    br.close();
                    pw.flush();
                    pw.close();
                    file.delete();
                    temp.renameTo(file);

                    //System.out.println("File Modified"); 
            }
            
            
            if(flag==0)
                        {
                            System.out.println("Record NOT found");
                            System.out.println(); 
                        }
        



 
}
   
    public void write(String name, String usn, String phno, String dob, String key) throws FileNotFoundException
    {  
            char ch1 = key.charAt(0); 
            char ch2 = key.charAt(1);   
            if(ch1=='1')
            {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("cse/"+ch2+".txt"),true));
            String b = usn + "|" + name + "|" + phno + "|" + dob + "|";
            pw.println(b);
            pw.flush();
            pw.close();
            }
            else if(ch1=='2')
            {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("ise/"+ch2+".txt"),true));
            String b = usn + "|" + name + "|" + phno + "|" + dob + "|";
            pw.println(b);
            pw.flush();
            pw.close();
            }
            else if(ch1=='3')
            {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("tce/"+ch2+".txt"),true));
            String b = usn + "|" + name + "|" + phno + "|" + dob + "|";
            pw.println(b);
            pw.flush();
            pw.close();
            }
           else
            {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("ece/"+ch2+".txt"),true));
            String b = usn + "|" + name + "|" + phno + "|" + dob + "|";
            pw.println(b);
            pw.flush();
            pw.close();
            }
     }
   
    public String hashTable(String branch, String year)
    {   
    String key2="";
    String key1="";
    String key;
    if(branch.equalsIgnoreCase("cse"))
        key1="1";
    else if(branch.equalsIgnoreCase("ise"))
        key1="2";
    else if(branch.equalsIgnoreCase("tce"))
        key1="3";
    else if(branch.equalsIgnoreCase("ece"))
        key1="4";
    if(year.equalsIgnoreCase("1"))
        key2="1";
    else if(year.equalsIgnoreCase("2"))
        key2="2";
    else if(year.equalsIgnoreCase("3"))
        key2="3";
    else if(year.equalsIgnoreCase("4"))
        key2="4";
    key=key1+key2;
    return (key);
    }

    public String hash1(String usn){
        String yr="";
        if(usn.contains("20")){
            yr="1";
        }
        else if(usn.contains("19")){
            yr="2";
        }
        else if(usn.contains("18")){
            yr="3";
        }
        else if(usn.contains("17")){
            yr="4";
        }

           return (yr);

    }    
}