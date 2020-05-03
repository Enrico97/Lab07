package it.polito.tdp.poweroutages;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.poweroutages.model.Model;
import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutAges;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Nerc> boxSelect;

    @FXML
    private TextField txtAnni;

    @FXML
    private TextField txtOre;

    @FXML
    private Button btnAnalizza;

    @FXML
    private TextArea txtResult;

    @FXML
    void analizza(ActionEvent event) {
    	int i=0;
    	int x=0;
    	txtResult.clear();
    	if(txtAnni.getText()==null) {
    		txtResult.setText("devi inserire un numero");
    		txtAnni.clear();
    		return;}
    	if(txtOre.getText()==null) {
    		txtResult.setText("devi inserire un numero");
    		txtOre.clear();
    		return;}
    	if(boxSelect.getValue()==null) {
    		txtResult.setText("devi selezionare un nerc");
    		txtAnni.clear();
    		txtOre.clear();
    		return;}
    	try {
    		for(PowerOutAges p : model.soluzione(boxSelect.getValue(), Integer.parseInt(txtAnni.getText()), Integer.parseInt(txtOre.getText()))) {
    			i+=p.getColpiti(); 
    			x+=p.getDatafine().minusHours(p.getDataInizio().getHour()).getHour();
    		}
			txtResult.appendText("il numero totale di colpiti è: "+i+"\n");
			txtResult.appendText("il numero totale di ore è: "+x+"\n");
    		for(PowerOutAges p : model.soluzione(boxSelect.getValue(), Integer.parseInt(txtAnni.getText()), Integer.parseInt(txtOre.getText()))) 
    			txtResult.appendText(p.toString());
}
    	catch (Exception e) {
    		txtAnni.clear();
    		txtOre.clear();
    		txtResult.appendText("devi inserire dei numeri");
    	}

    }

    @FXML
    void select(ActionEvent event) {
    	txtResult.clear();
    }
    
    public void setModel(Model model) {
    	this.model=model;
    	boxSelect.getItems().addAll(model.getNercList());
    }

    @FXML
    void initialize() {
        assert boxSelect != null : "fx:id=\"boxSelect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnni != null : "fx:id=\"txtAnni\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOre != null : "fx:id=\"txtOre\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
