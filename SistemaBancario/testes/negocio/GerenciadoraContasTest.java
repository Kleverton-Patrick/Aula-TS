package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
Classe de teste criada para garantir o funcionamento das principais opera Des sobre contas, realizadas pela classe Gerenciadora Contas.
*/

public class GerenciadoraContasTest {
	
	private GerenciadoraContas gerContas;
	
	/**
	Valida o de transferOncia entre contas.
	• Cen rio: Saldo suficiente em ambas as contas
	*/
	
	@Test
	public void testTransfereValor () {

		/* === Montagem do cenário ===*/
		
		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		// inserindo os clientes sciados na lista de clientes do banco
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);
		
		/* === Execução === */
		boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
		
		/* === Verificações === */
		assertTrue(sucesso);
		assertThat(conta02.getSaldo(), is(100.0));
		assertThat(conta01.getSaldo(), is(100.0));
	}
}
