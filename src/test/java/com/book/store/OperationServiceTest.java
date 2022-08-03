package com.book.store;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OperationServiceTest {
//	@Mock
//	TransactionRepository transactionRepository;
//
//	@Mock
//	AccountService accountService;
//
//	@InjectMocks
//	TransactionService transactionService;
//
//	@Test()
//	public void testTranferMoney() {
//		String debitId = new String("3d253e29-8785-464f-8fa0-9e4b57699db9");
//		String creditId = new String("17f904c1-806f-4252-9103-74e7a5d3e340");
//		String name = new String("Junit");
//		BigDecimal amount = new BigDecimal(10);
//
//		Account drAccount = new Account(debitId, name, BigDecimal.TEN);
//		Account crAccount = new Account(creditId, name, BigDecimal.TEN);
//
//		when(accountService.getAccountById(debitId)).thenReturn(Optional.of(drAccount));
//		when(accountService.getAccountById(creditId)).thenReturn(Optional.of(crAccount));
//
//		Transaction request = new Transaction();
//		request.setDebitId(debitId);
//		request.setCreditId(creditId);
//		request.setAmount(amount);
//
//		transactionService.tranferMoney(request);
//
//		assertEquals(BigDecimal.ZERO, drAccount.getBalance());
//		assertEquals(BigDecimal.TEN.add(BigDecimal.TEN), crAccount.getBalance());
//	}
//
//	@Test(expected = InsufficientBalanceException.class)
//	public void testInsufficientBalanceException() {
//		String debitId = new String("3d253e29-8785-464f-8fa0-9e4b57699db9");
//		String creditId = new String("17f904c1-806f-4252-9103-74e7a5d3e340");
//		String name = new String("Junit");
//		BigDecimal amount = new BigDecimal(20);
//
//		Account drAccount = new Account(debitId, name, BigDecimal.TEN);
//		Account crAccount = new Account(creditId, name, BigDecimal.TEN);
//
//		when(accountService.getAccountById(debitId)).thenReturn(Optional.of(drAccount));
//		when(accountService.getAccountById(creditId)).thenReturn(Optional.of(crAccount));
//
//		Transaction request = new Transaction();
//		request.setDebitId(debitId);
//		request.setCreditId(creditId);
//		request.setAmount(amount);
//
//		transactionService.tranferMoney(request);
//
//	}
//
//	@Test(expected = AccountDoesNotExistException.class)
//	public void testAccountDoesNotExistException() {
//		String debitId = new String("3d253e29-8785-464f-8fa0-9e4b57699db9");
//		String creditId = new String("17f904c1-806f-4252-9103-74e7a5d3e340");
//		String name = new String("Junit");
//		BigDecimal amount = new BigDecimal(20);
//
//		Account drAccount = new Account(debitId, name, BigDecimal.TEN);
//		Account crAccount = new Account(creditId, name, BigDecimal.TEN);
//
//		when(accountService.getAccountById(debitId)).thenReturn(Optional.empty());
//
//		Transaction request = new Transaction();
//		request.setDebitId(debitId);
//		request.setCreditId(creditId);
//		request.setAmount(amount);
//
//		transactionService.tranferMoney(request);
//
//		assertEquals(BigDecimal.ZERO, drAccount.getBalance());
//		assertEquals(BigDecimal.TEN.add(BigDecimal.TEN), crAccount.getBalance());
//	}

}
