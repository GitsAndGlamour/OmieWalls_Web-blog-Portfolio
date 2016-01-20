

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DumbTextPhone extends JFrame {
		ArrayList<PhoneBookEntry> contacts = new ArrayList<PhoneBookEntry>();
        private static final long serialVersionUID = 1L;
        private static final int WIDTH = 300;
        private static final int HEIGHT = 500;
        private JTextArea display;
        private JPanel taskPanel;
        private static JButton left, right, middle;
        private static boolean set1, set2, set3, set4, set5, isNumberMode, isLetterMode, isHome;
        private static String entry, letter;
        private static String a="A",b="B",c="C",d="D",e="E",f="F",g="G",h="H",i="I",j="J",k="K",l="L",m="M",n="N",o="O",p="P",q="Q",r="R",s="S",t="T",u="U",v="V",w="W",x="X",y="Y",z="Z";
        private static int counter, cnt;
        private static String lastChar, name, number;
        private static double duration;
    	public DumbTextPhone() {
                setTitle("Telephone Keypad");
            setSize(WIDTH, HEIGHT);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            createContents();
            setVisible(true);
        }

        private void createContents() {

                //TODO: create JPanel for keypad buttons 0-9, *, and #.
                //Make use of the BorderLayout and GridLayout managers.
                JPanel keypad = new JPanel(new GridLayout(4, 3));
                keypad.setPreferredSize(new Dimension(300,300));

                JPanel taskPanel = new JPanel(new GridLayout(1,3));
                taskPanel.setPreferredSize(new Dimension(300,100));

                //create JTextArea display
                display = new JTextArea();
                display.setPreferredSize(new Dimension(280, 80));
                display.setFont(new Font("Helvetica", Font.PLAIN, 32));
                display.setLineWrap(true);
        //TODO: create JButtons


        //TODO: add JButtons to buttons JPanel
                JButton one = new JButton("1");

                JButton two = new JButton("2");
                JButton three = new JButton("3");
                JButton four = new JButton("4");
                JButton five = new JButton("5");
                JButton six = new JButton("6");
                JButton seven = new JButton("7");
                JButton eight = new JButton("8");
                JButton nine = new JButton("9");
                JButton ten = new JButton("*");
                JButton eleven = new JButton("0");
                JButton twelve = new JButton("#");
                left = new JButton("<");
                middle = new JButton("add contact");
                right = new JButton(">");




                keypad.add(one);
                keypad.add(two);
                keypad.add(three);
                keypad.add(four);
                keypad.add(five);
                keypad.add(six);
                keypad.add(seven);
                keypad.add(eight);
                keypad.add(nine);
                keypad.add(ten);
                keypad.add(eleven);
                keypad.add(twelve);

        //TODO: add Listener inner class instance to buttons
                Listener listen = new Listener();
                one.addActionListener(listen);
                two.addActionListener(listen);
                three.addActionListener(listen);
                four.addActionListener(listen);
                five.addActionListener(listen);
                six.addActionListener(listen);
                seven.addActionListener(listen);
                eight.addActionListener(listen);
                nine.addActionListener(listen);
                ten.addActionListener(listen);
                eleven.addActionListener(listen);
                twelve.addActionListener(listen);
                add(left, listen);
                add(middle,listen);
                add(right,listen);


        //TODO: add display and buttons to keypad
                setLayout(new BorderLayout());
                add(display, BorderLayout.NORTH);
                add(taskPanel, BorderLayout.CENTER);
                add(keypad, BorderLayout.SOUTH);

                taskPanel.add(left);
            	taskPanel.add(middle);
            	taskPanel.add(right);




    		 }
        public void add(JButton button, Listener listen) {
    		button.addActionListener(listen);
        }
        private class Listener implements ActionListener {

                public void actionPerformed(ActionEvent ae) {
                	entry =  ae.getActionCommand();
                	isNumberMode=true;
                	if(isNumberMode == true) {
                		if(entry.equals("delete"))
                			display.setText(display.getText());
                		else if(isLetterMode ==false)
                		display.setText(display.getText() + entry);
                	}
                   	if(isLetterMode == true) {
                   		isNumberMode = false;
                   		if(entry.equals("delete") || entry.equals("1") || entry.equals("0") || entry.equals("*") || entry.equals("#")){

                   			letter = "";
                   		}
    	    			if(entry.contains("2")){
    	    					entry = a + b + c;

    	    			 		if(duration < 1000) {
    	    			 			letter = Character.toString(entry.charAt(counter++));
    	    			 			if (counter==3) {
    	    			 				counter=0;
    	    			 			}
    	    			 		}

    	    			 		else
    	    			 			letter = Character.toString(entry.charAt(0));
    	    			 }
    	    			  else if(entry.contains("3")) {
    	    			   		entry = d + e + f;

    	    			 		if(duration < 1000) {
    	    			 			letter = Character.toString(entry.charAt(counter++));
    	    			 			if (counter==3) {
    	    			 				counter=0;
    	    			 			}
    	    			 		}

    	    			 		else
    	    			 			letter = Character.toString(entry.charAt(0));
    	    			  }
    	    			  else if(entry.contains("4")) {
    	    			  	 entry = g + h + i;

    	    			 		if(duration < 1000) {
    	    			 			letter = Character.toString(entry.charAt(counter++));
    	    			 			if (counter==3) {
    	    			 				counter=0;
    	    			 			}
    	    			 		}

    	    			 		else
    	    			 			letter = Character.toString(entry.charAt(0));
    	    			  }
    	    			   else if(entry.contains("5")) {
    	    			   	 entry = l + k + j;

    	    			 		if(duration < 1000) {
    	    			 			letter = Character.toString(entry.charAt(counter++));
    	    			 			if (counter==3) {
    	    			 				counter=0;
    	    			 			}
    	    			 		}
    	    			 		else
    	    			 			letter = Character.toString(entry.charAt(0));
    	    			   }
    	    			   else if(entry.contains("6")) {
    	    			   	 entry = m + n + o;

    	    			 		if(duration < 1000) {
    	    			 			letter = Character.toString(entry.charAt(counter++));
    	    			 			if (counter==3) {
    	    			 				counter=0;
    	    			 			}
    	    			 		}

    	    			 		else
    	    			 			letter = Character.toString(entry.charAt(0));
    	    			   }
    	    			   else if(entry.contains("7")) {
    	    			   	 entry = p + q + r + s;

    	    			 		if(duration < 1000) {
    	    			 			letter = Character.toString(entry.charAt(counter++));
    	    			 			if (counter==4) {
    	    			 				counter=0;
    	    			 			}
    	    			 		}

    	    			 		else
    	    			 			letter = Character.toString(entry.charAt(0));
    	    			   }
    	    			   else if(entry.contains("8")) {
    	    			   	 entry = t + u + v;

    	    			 		if(duration < 1000) {
    	    			 			letter = Character.toString(entry.charAt(counter++));
    	    			 			if (counter==3) {
    	    			 				counter=0;
    	    			 			}
    	    			 		}

    	    			 		else
    	    			 			letter = Character.toString(entry.charAt(0));
    	    			   }
    	    			   else if(entry.contains("9")) {
    	    			   	 entry = w + x + y + z;

    	    			 		if(duration < 1000) {
    	    			 			letter = Character.toString(entry.charAt(counter++));
    	    			 			if (counter==4) {
    	    			 				counter=0;
    	    			 			}
    	    			 		}

    	    			 		else
    	    			 			letter = Character.toString(entry.charAt(0));
    	    			   }

    	    			 display.setText(display.getText()+letter);
    	    	}
                   	if(entry.equals("delete")){
                   		display.setText(deleteLastChar(display.getText()));
                   	}
                   if(isHome ==true)
                	   isNumberMode = true;
                    if(entry.equals("enter")) {
                      	isLetterMode = true;
                      	isHome = false;
                      	isNumberMode = false;
                      	display.setText("ENTER MESSAGE");
                      	left.setText("delete");
                      	middle.setText("send");
                      	right.setText("home");
                      	if(display.getText().contains("ENTER MESSAGE"+entry))
                			display.setText(entry+=entry);
                      		}

                   	if(!display.getText().contains("ENTER MESSAGE") && !display.getText().contains("ENTER NUMBER") && !display.getText().contains("ENTER NAME") && isNumberMode) {
                   		if(!display.getText().isEmpty()) {

                   			left.setText("delete");
                          	middle.setText("enter");
                          	right.setText("home");
                   		}
                   	}

                   		if(entry.equals("add contact")) {
                        	isLetterMode = true;
                        	isNumberMode = false;
                        	isHome = false;
                        	display.setText("ENTER NAME       ");
                        	left.setText("delete");
                        	middle.setText("submit name");
                        	right.setText("home");
                        			name = "";
                        			name += display.getText();

                        }


                        	if(entry.equals("submit name")) {
                        		isNumberMode = true;
                        		isLetterMode = false;
                        		isHome = true;
                        		display.setText("ENTER NUMBER");
                        		left.setText("delete");
                            	middle.setText("store contact");
                            	right.setText("home");
                            		number = "";
                            	number += display.getText();
                        	}

                        		if(entry.equals("store contact") || entry.equals("home") || entry.equals("send")) {
                        			isNumberMode = true;
                        			isLetterMode = false;
                        			isHome = true;
                        			if(entry.equals("home")) {
                        			display.setText("");
                        			}
                        			else if(entry.equals("store contact")) {
                        				addContact(contacts,name,number);
                        			display.setText("CONTACT STORED");
                        			}
                        			else
                        				display.setText("TEXT SENT");
                                	left.setText("<");
                                	middle.setText("add contact");
                                	right.setText(">");
                        		}
                        		if(entry.equals("<")) {
                        			int cnt = 0;
                        			if(contacts.size() == 0) {
                        	            display.setText("NO CONTACTS");
                        	          }
                        	          else {
                        	            if (cnt == 0)
                        	            cnt = contacts.size()-1;
                        	            display.setText(contacts.get(cnt).getName());
                        	            display.getText();
                        	            --cnt;
                        	          }
                        			left.setText("<");
                                	middle.setText("add contact");
                                	right.setText(">");

                        	        }

                        		if(entry.equals(">")) {
                        			int cnt = 0;
                        			if(contacts.size() == 0) {
                        	            display.setText("NO CONTACTS");

                        	          }
                        	          else {
                        	            if (cnt == contacts.size()-1)
                        	              cnt = 0;
                        	            display.setText(contacts.get(cnt).getName());
                        	            display.getText();
                        	            ++cnt;
                        	          }
                        			left.setText("<");
                                	middle.setText("add contact");
                                	right.setText(">");

                        		}
                	}

                        }
        public String deleteLastChar(String str) {
        	  String displayString = "";
        	  if(str.length() == 0) {
        	    return displayString;
        	  }
        	    else {
        	      for(int i = 0; i < str.length()-1; i++) {
        	        displayString += str.charAt(i);
        	      }
        	      return displayString;
        	    }
        }
        public String clearPrompt(String str, String prompt) {
        	String displayString = "";
        	if(!str.equals(prompt)){
        		display.setText("");
        		displayString += Character.toString(str.charAt(str.length()-1));
        	}
			return displayString;
        }
        public ArrayList<PhoneBookEntry> getContacts() {
			return contacts;
		}
		public void setContacts(ArrayList<PhoneBookEntry> contacts) {
			this.contacts = contacts;
		}
		public void addContact(ArrayList<PhoneBookEntry> contacts, String name, String number) {
			PhoneBookEntry contact = new PhoneBookEntry(name);
			contact.setNumber(number);
			contacts.add(contact);

		}
        public static void main(String[] args) {
                new DumbTextPhone();
        }
}