package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest {
	
	private GerenciadoraClientes gerClientes;
	private int idCliente1 = 1;
	private int idCliente2 = 2;
	
	@Before
	public void setUp(){
		
		/* === Montagem do cenário === */
		
		//criando alguns clientes
		Cliente cliente01 = new Cliente(idCliente1, "João", 31, "joao@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente2, "Maria", 34, "maria@gmail.com", 1, true);
		
		//inserindo os clientes criados na lista de clientes do banco
		
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
	}
	
	@After
	public void tearDown() {
		gerClientes.limpa();
	}
	
	/**
	 * Teste básico da consulta de um cliente a partir do seu ID.
	 * 
	 */
	
	@Test
	public void testPesquisaCliente() {
		
		/* === Execução ===*/
		Cliente cliente = gerClientes.pesquisaCliente(idCliente1);
		
		/* === Verificações ===*/
		assertThat(cliente.getId(), is(idCliente2));
		
	}
	
	/**
	 * Teste básico da remoção de um cliente a partir do seu ID.
	 * 
	 */
	@Test
	public void testRemoveCliente() {
		
		/* === Execução ===*/
		boolean clienteRemovido = gerClientes.removeCliente(idCliente2);
		
		/* === Verificações ===*/
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente2));
		
	}

}
