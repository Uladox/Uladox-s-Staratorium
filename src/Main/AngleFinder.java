package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * This file is part of Uladox's Staratorium.
 *
 *   Uladox's Staratorium is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  Uladox's Staratorium is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *  along with Uladox's Staratorium.  If not, see <http://www.gnu.org/licenses/>.
 * @author Uladox
 * 
 */

/**
 * Do what you want with this code, I just like bragging about having a lisence
 * I might get official copyright, but it costs quite a bit for the U.S. Copyright office
 * to make it official.
 * @author Uladox
 *
 */
public class AngleFinder extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel window;
	
	private Boolean Cleared = false;
	
	private JButton AngleFinder, Save, Clear, Importer;
	private Rectangle rAngleFinder, rAbout, rDefinitions, rClear, rImporter;
	private JTextField Star1, RA1H, RA1M, RA1S,Dec1D, Dec1AM, Dec1AS;
	private JTextField Star2, RA2H, RA2M, RA2S,Dec2D, Dec2AM, Dec2AS;
	private JTextField SA, PA;
	public BufferedImage IconStars;
	
	private JLabel Star1l, RA1Hl, RA1Ml, RA1Sl,Dec1Dl, Dec1AMl, Dec1ASl, Star2l;
	//private JLabel Star2l, RA2Hl, RA2Ml, RA2Sl,Dec2Dl, Dec2AMl, Dec2ASl;
	
	private int ButtonWidth = 200;
	private int ButtonHeight = 40;
	
	public int TextWidth = 80;
	public int TextHeight = 30;
	
	private int Width = 1000;
	private int Height = 640;
	
	 final static Charset ENCODING = StandardCharsets.UTF_8;

	
	public AngleFinder(){
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e){
			e.printStackTrace();
		}
		IconStars = getImage("/ImageIcon.png");
		setIconImage(IconStars);
		
		setTitle("Uladox's Staratorium Angle Calculator V 0.1");
		setSize(new Dimension(Width, Height));
		window = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(window);
		setLocationRelativeTo(null);
		setResizable(false);
		window.setLayout(null);
		
		drawFeatures();
		this.setVisible(true);
		getContentPane().setBackground(Color.decode("0x3F8A53"));
		
	}
	
	public void drawFeatures(){
		
		//private JTextField Star1, RA1H, RA1M, RA1S,Dec1D, Dec1AM, Dec1AS;
		//private JTextField Star2, RA2H, RA2M, RA2S,Dec2D, Dec2AM, Dec2AS;
		
		Star1 = new JTextField();
		Star1.setBounds(67, 50, TextWidth, TextHeight);
		Star1.setColumns(10);
		window.add(Star1);
		
		Star1l = new JLabel("Star 1");
		Star1l.setBounds(37, 30, TextWidth, TextHeight);
		window.add(Star1l);
		
		RA1H = new JTextField();
		RA1H.setBounds(167, 50, TextWidth, TextHeight);
		RA1H.setColumns(10);
		window.add(RA1H);
		
		RA1Hl = new JLabel("RA H");
		RA1Hl.setBounds(167, 30, TextWidth, TextHeight);
		window.add(RA1Hl);
		
		RA1M = new JTextField();
		RA1M.setBounds(267, 50, TextWidth, TextHeight);
		RA1M.setColumns(10);
		window.add(RA1M);
		
		RA1Ml = new JLabel("RA M");
		RA1Ml.setBounds(267, 30, TextWidth, TextHeight);
		window.add(RA1Ml);
		
		RA1S = new JTextField();
		RA1S.setBounds(367, 50, TextWidth, TextHeight);
		RA1S.setColumns(10);
		window.add(RA1S);
		
		RA1Sl = new JLabel("RA S");
		RA1Sl.setBounds(367, 30, TextWidth, TextHeight);
		window.add(RA1Sl);
		
		Dec1D = new JTextField();
		Dec1D.setBounds(467, 50, TextWidth, TextHeight);
		Dec1D.setColumns(10);
		window.add(Dec1D);
		
		Dec1Dl = new JLabel("Dec D");
		Dec1Dl.setBounds(467, 30, TextWidth, TextHeight);
		window.add(Dec1Dl);
		
		Dec1AM = new JTextField();
		Dec1AM.setBounds(567, 50, TextWidth, TextHeight);
		Dec1AM.setColumns(10);
		window.add(Dec1AM);
		
		Dec1AMl = new JLabel("Dec AM");
		Dec1AMl.setBounds(567, 30, TextWidth, TextHeight);
		window.add(Dec1AMl);
		
		Dec1AS = new JTextField();
		Dec1AS.setBounds(667, 50, TextWidth, TextHeight);
		Dec1AS.setColumns(10);
		window.add(Dec1AS);
		
		Dec1ASl = new JLabel("Dec AS");
		Dec1ASl.setBounds(667, 30, TextWidth, TextHeight);
		window.add(Dec1ASl);
		

		//private JTextField Star2, RA2H, RA2M, RA2S,Dec2D, Dec2AM, Dec2AS;
		
		Star2 = new JTextField();
		Star2.setBounds(67, 100, TextWidth, TextHeight);
		Star1.setColumns(10);
		window.add(Star2);
		
		Star2l = new JLabel("Star 2");
		Star2l.setBounds(37, 100, TextWidth, TextHeight);
		window.add(Star2l);
		
		RA2H = new JTextField();
		RA2H.setBounds(167, 100, TextWidth, TextHeight);
		RA2H.setColumns(10);
		window.add(RA2H);
		
		
		
		RA2M = new JTextField();
		RA2M.setBounds(267, 100, TextWidth, TextHeight);
		RA2M.setColumns(10);
		window.add(RA2M);
		
		
		RA2S = new JTextField();
		RA2S.setBounds(367, 100, TextWidth, TextHeight);
		RA2S.setColumns(10);
		window.add(RA2S);
		
		
		Dec2D = new JTextField();
		Dec2D.setBounds(467, 100, TextWidth, TextHeight);
		Dec2D.setColumns(10);
		window.add(Dec2D);
		
		
		
		Dec2AM = new JTextField();
		Dec2AM.setBounds(567, 100, TextWidth, TextHeight);
		Dec2AM.setColumns(10);
		window.add(Dec2AM);
		
		
		
		Dec2AS = new JTextField();
		Dec2AS.setBounds(667, 100, TextWidth, TextHeight);
		Dec2AS.setColumns(10);
		window.add(Dec2AS);
		
		SA = new JTextField();
		SA.setBounds(300, 250, TextWidth + 100, TextHeight+100);
		SA.setColumns(10);
		window.add(SA);
		
		PA = new JTextField();
		PA.setBounds(500, 250, TextWidth +100, TextHeight+100);
		PA.setColumns(10);
		window.add(PA);
		
		Clear = new JButton("Clear");
		rClear = new Rectangle((Width/2) - (ButtonWidth/2) + 200, 400, ButtonWidth, ButtonHeight);
		Clear.setBounds(rClear);
		window.add(Clear);
		
		Importer = new JButton("Import .txt File");
		rImporter = new Rectangle((Width/2) - (ButtonWidth/2) -200, 400, ButtonWidth, ButtonHeight);
		Importer.setBounds(rImporter);
		window.add(Importer);
		
		Importer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FileImporter fileI = new FileImporter();
				URL f = fileI.FileLocation;
				String p = String.valueOf(f);
				p = p.replace("file:/", "");
				//System.out.println(p);
				try {
					List<String> lines = readSmallTextFile(p);
					input(lines);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    //log(lines);
			    
				
			}
		});
		
		Clear.addActionListener(new ActionListener(){
			public  void actionPerformed(ActionEvent e){
			//	float a = Float.parseFloat(SA.getText());
				if( !(SA.getText().length() == 0)
					||!(PA.getText().length() == 0)
					||!(RA1H.getText().length() == 0)
					||!(RA1M.getText().length() == 0)
					||!(RA1S.getText().length() == 0)
					||!(Dec1D.getText().length() == 0)
					||!(Dec1AM.getText().length() == 0)
					||!(Dec1AS.getText().length() == 0)
					
					||!(RA2H.getText().length() == 0)
					||!(RA2M.getText().length() == 0)
					||!(RA2S.getText().length() == 0)
					||!(Dec2D.getText().length() == 0)
					||!(Dec2AM.getText().length() == 0)
					||!(Dec2AS.getText().length() == 0)){
					
					System.out.println(Dec2AS.getText().length());
					
					SA.setText("");
					PA.setText("");
					RA1H.setText("");
					RA1M.setText("");
					RA1S.setText("");
					Dec1D.setText("");
					Dec1AM.setText("");
					Dec1AS.setText("");
					
					RA2H.setText("");
					RA2M.setText("");
					RA2S.setText("");
					Dec2D.setText("");
					Dec2AM.setText("");
					Dec2AS.setText("");
					
					
					
				}
				else{
					
					
			
					
					Star1.setText("");
					Star2.setText("");
					
				}
			}
		});
		
				
		AngleFinder = new JButton("Calculate");
		rAngleFinder = new Rectangle((Width/2) - (ButtonWidth/2), 400, ButtonWidth, ButtonHeight);
		AngleFinder.setBounds(rAngleFinder);
		window.add(AngleFinder);
		
		
		AngleFinder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				float dec1neg = Math.abs(Float.parseFloat(Dec1D.getText()))/Float.parseFloat(Dec1D.getText());
				float dec2neg = Math.abs(Float.parseFloat(Dec2D.getText()))/Float.parseFloat(Dec2D.getText());
				float ra1neg = Math.abs(Float.parseFloat(RA1H.getText()))/Float.parseFloat(RA1H.getText());
				float ra2neg = Math.abs(Float.parseFloat(RA2H.getText()))/Float.parseFloat(RA2H.getText());
				
				double Dec1 = dec1neg*(3600 * Math.abs(Double.parseDouble(Dec1D.getText())) + (60 * Double.parseDouble(Dec1AM.getText()))
						+ (Double.parseDouble(Dec1AS.getText())));
				
				
				double Dec2 = dec2neg*(3600 * Math.abs(Double.parseDouble(Dec2D.getText())) + (60 * Double.parseDouble(Dec2AM.getText()))
						+ (Double.parseDouble(Dec2AS.getText())));
				
				
				double RA1 = ra1neg*(3600 * Math.abs(Double.parseDouble(RA1H.getText())) + (60 * Double.parseDouble(RA1M.getText()))
						+ (Double.parseDouble(RA1S.getText())));
				
				double RA2 = ra2neg*(3600 * Math.abs(Double.parseDouble(RA2H.getText())) + (60 * Double.parseDouble(RA2M.getText()))
						+ (Double.parseDouble(RA2S.getText())));
				
			double SAF = CalcSAPA(Dec1, Dec2, RA1, RA2, 0);
			double PAF = CalcSAPA(Dec1, Dec2, RA1, RA2, 1);
			SA.setText(SAF + "");
			PA.setText(PAF + "");
			
				
			}
		});
		
		
		
	}
	public double CalcSAPA(double Dec1, double Dec2, double RA1, double RA2, int AngleType){
		double AvrgDec = (Dec1 + Dec2)/2;
		///System.out.println(15*Math.cos(((AvrgDec)/3600)*Math.PI/180) * (RA1 - RA2));
		System.out.println(Dec1 +" " +Dec2+ " " + AvrgDec);
		double conDec=15*Math.cos(((AvrgDec)/3600)*Math.PI/180);
		double returntype = 0;
		double changeRA = RA2 - RA1;
		double changeDec = Dec1 - Dec2;
		double CconRA = conDec * changeRA;
		
		double SADouble = Math.sqrt(
		(changeDec)*(changeDec) + 
		CconRA *CconRA
		);
		
		double pa1angle = Math.asin(CconRA/SADouble);
		double pa1 = (pa1angle*360)/(2*Math.PI);
		System.out.println(pa1 +"	" + changeRA + "	" + changeDec);
		
		double ValuePA = 0;
		if(changeRA >0 && changeDec >0){
			ValuePA = pa1;
		}
		else if(changeRA >0 && changeDec <0){
			ValuePA = 180 - pa1;
		}
		else if(changeRA <0 && changeDec >0){
			ValuePA = 360 + pa1;
		}
		else if(changeRA <0 && changeDec <0){
			ValuePA = 180 - pa1;
		}
		if(AngleType == 0){
			returntype = SADouble;
		return returntype;
		}
		else if(AngleType == 1){
			returntype = ValuePA;
			return returntype;
		}
		return returntype;
	}
	private static void log(Object aMsg){
	    System.out.println(String.valueOf(aMsg));
	  }
	List<String> readSmallTextFile(String aFileName) throws IOException {
	    Path path = Paths.get((aFileName));
	    //File file = new File(Saving.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	    return Files.readAllLines(path, ENCODING);
	  }
	public void input(Object lines){
		String filetxt = String.valueOf(lines);
		String[] output = filetxt.split(" ");
		
		Star1.setText(output[0].replace("[", "").replace(",", ""));
		RA1H.setText(output[1].replace(",", ""));
		RA1M.setText(output[2].replace(",", ""));
		RA1S.setText(output[3].replace(",", ""));
		Dec1D.setText(output[4].replace(",", ""));
		Dec1AM.setText(output[5].replace(",", ""));
		Dec1AS.setText(output[6].replace(",", ""));
		
		Star2.setText(output[7].replace(",", ""));
		RA2H.setText(output[8].replace(",", ""));
		RA2M.setText(output[9].replace(",", ""));
		RA2S.setText(output[10].replace(",", ""));
		Dec2D.setText(output[11].replace(",", ""));
		Dec2AM.setText(output[12].replace(",", ""));
		Dec2AS.setText(output[13].replace("]", "").replace(",", ""));
		
		//String result = output[0];
		//String result2 = output[1];
		//String result3 = output[2];
		//System.out.println(result);
		//System.out.println("						" + result2);
		//System.out.println(result3);
	}
	 private BufferedImage getImage(String filename) {
         // This time, you can use an InputStream to load
         try {
                 // Grab the InputStream for the image.
                 InputStream in = getClass().getResourceAsStream(filename);
                 
                 // Then read it in.
                 return ImageIO.read(in);
         } catch (IOException e) {
                 System.out.println("The image was not loaded.");
                 System.exit(1);
         }
         return null;
 }

}