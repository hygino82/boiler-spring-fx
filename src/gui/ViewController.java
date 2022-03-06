package gui;

import entity.SpringModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ViewController {
	@FXML
	private TextField txtPacote;

	@FXML
	private TextField txtEntidade;

	@FXML
	private Button btnGerar;

//	@FXML
//	private TreeView<String> diretorio;

	@FXML
	public void btnGerarAction() {
		String mainPackage = txtPacote.getText();
		String name = txtEntidade.getText();
		SpringModel modelo = new SpringModel(mainPackage, name);
		System.out.println(modelo.toModel());
	}
}
