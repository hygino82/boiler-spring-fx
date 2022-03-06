package entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SpringModel {

	private String mainPackage;
	private String name;

	public SpringModel(String mainPackage, String name) {
		this.mainPackage = mainPackage;
		this.name = name;
	}

	public SpringModel() {

	}

	public String getMainPackage() {
		return mainPackage;
	}

	public void setMainPackage(String mainPackage) {
		this.mainPackage = mainPackage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SpringModel [mainPackage=" + mainPackage + ", name=" + name + "]";
	}

	public String toModel() {
		StringBuilder sb = new StringBuilder();
		sb.append("package " + mainPackage + ".model;\n\n");

		sb.append("import javax.persistence.Entity;\n" + "import javax.persistence.GeneratedValue;\n"
				+ "import javax.persistence.GenerationType;\n" + "import javax.persistence.Id;\n"
				+ "import javax.persistence.Table;\n" + "\n" + "import lombok.AllArgsConstructor;\n"
				+ "import lombok.Data;\n" + "import lombok.NoArgsConstructor;\n\n" + "@Data\n" + "@AllArgsConstructor\n"
				+ "@NoArgsConstructor\n" + "@Entity\n" + "@Table\n");

		sb.append("public class " + name + "{\n");
		sb.append("@Id\n" + "@GeneratedValue(strategy = GenerationType.IDENTITY)\n" + "    private Long id;\n");

		sb.append("private String name;\n");
		sb.append("}");

		return sb.toString();
	}

	public void saveModel() {
		String caminho="/home/hygino/boiler/model/";
		if (!new File(caminho).exists()) {
            new File(caminho).mkdir();
        } else {
            System.out.println("Pasta caminho já existe ...");
        }
		
		File arquivo = new File("/home/hygino/boiler/model/" + name + ".java");
		try {
			if (!arquivo.exists()) {
				// cria um arquivo (vazio)
				arquivo.createNewFile();
			}
			// caso seja um diretório, é possível listar seus arquivos e diretórios
			//File[] arquivos = arquivo.listFiles();
			// escreve no arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(toModel());
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
