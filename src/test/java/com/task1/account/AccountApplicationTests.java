package com.task1.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class AccountApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	/*
	 * @Test void users_returns_expected_list_of_users() { final Integer
	 * expectedPage = 1; final Integer expectedSize = 10; final LoggedUserDto
	 * activeUser = createActiveUser(); final List<UserDto> expectedUsers =
	 * Arrays.asList(new UserDto(), new UserDto(), new UserDto());
	 * when(userServiceMock.users(expectedPage, expectedSize,
	 * activeUser)).thenReturn(expectedUsers); final List<UserDto> actualUsers =
	 * userController.users(expectedPage, expectedSize, activeUser);
	 * 
	 * assertEquals(expectedUsers, actualUsers); verify(userServiceMock,
	 * times(1)).users(expectedPage, expectedSize, activeUser); }
	 * 
	 * @Test void user_returns_expected_user() throws NonExistingEntityItem { final
	 * Long userId = 1L; final UserDto expectedUser = new UserDto();
	 * expectedUser.setId(userId);
	 * when(userServiceMock.user(userId)).thenReturn(expectedUser); final UserDto
	 * actualUser = userController.user(userId);
	 * 
	 * assertEquals(expectedUser, actualUser); verify(userServiceMock,
	 * times(1)).user(userId); }
	 * 
	 * @Test void unknown_user_throws_exception() {
	 * assertThrows(NonExistingEntityItem.class, () -> { final Long userId = 1L;
	 * when(userServiceMock.user(userId)).thenThrow(NonExistingEntityItem.class);
	 * userController.user(userId); }); }
	 * 
	 * @Test void adduser_returns_added_user() throws BusinessException { final
	 * AddUserDto userToAddMock = mock(AddUserDto.class);
	 * when(userServiceMock.addUser(userToAddMock)).thenReturn(any());
	 * userController.addUser(userToAddMock);
	 * 
	 * verify(userServiceMock, times(1)).addUser(userToAddMock); }
	 * 
	 * @Test void saveuser_returns_edited_user() throws BusinessException { final
	 * Long userId = 10L; final SaveUserDto saveUserDtoMock =
	 * mock(SaveUserDto.class); when(userServiceMock.saveUser(userId,
	 * saveUserDtoMock)).thenReturn(mock(UserDto.class));
	 * userController.saveUser(userId, saveUserDtoMock);
	 * 
	 * verify(userServiceMock, times(1)).saveUser(userId, saveUserDtoMock); }
	 */

}
