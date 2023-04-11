package entities;

public class Produto {
	private Long id;
	private String descricao;
	
	public Produto() { }

	public Produto(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toJson() {
		return "{\"id\": " + this.getId() + ", \"descricao\": \"" + this.getDescricao() + "\"}";
	}
	
	public static Produto fromJson(String requestBody) {
		String requestBodyClean = requestBody.replace("{", "").replace("}","");
		String[] splitProperties = requestBodyClean.split(",");
		Long jsonId = Long.parseLong(splitProperties[0].split(":")[1]);
		String jsonDescricao = splitProperties[0].split(":")[1];
		return new Produto(jsonId, jsonDescricao);
	}
}
