package exessoes;

// RumTImeEx n�o obriga o compilador trabalhar sem o rum precisa tratar tudo
public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	// serial precisa ter vers�o com a vers�o 1L que padrao
	public DomainException(String msg) {
		super(msg); // eu posso passar a minha mensagem
	}
}