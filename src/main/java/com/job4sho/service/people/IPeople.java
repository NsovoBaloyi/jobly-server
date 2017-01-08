package com.job4sho.service.people;

/**
 * Created by Nsovo on 2016/12/29.
 */
public interface IPeople {

    /**
     * Activates a newly created user's account in the system.
     * @param request The request encapsulated as an {@link ActivateRegistrationRequest} object.
     * @return Returns the result in an encapsulated {@link ActivateRegistrationResponse} object.
     * @throws NotAuthorizedException Thrown when an invalid key is presented.
     * @since 1.0.0
     */
    ActivateRegistrationResponse activateRegistration(ActivateRegistrationRequest request) throws NotAuthorizedException;


    /**
     * First set in the process for a user to reset their password. A unique token is sent to the user via email with
     * an associated link for them to reset their password with.
     * @param request The request encapsulated as an {@link RequestPasswordResetRequest} object.
     * @return Returns the result in an encapsulated {@link RequestPasswordResetResponse} object.
     * @throws EmailNotRegisteredException Thrown when the email specified in the request is not registered.
     * @throws NotAuthorizedException Thrown when the user has outstanding reset requests on their account.
     * @throws UserNotActivatedException Thrown when the user in question has not yet activated there account.
     * @throws EmailNotSentException Thrown when an email could not be sent to the user with there account detail.
     * @since 1.0.0
     */
    RequestPasswordResetResponse requestPasswordReset(RequestPasswordResetRequest request)
            throws EmailNotRegisteredException, NotAuthorizedException, UserNotActivatedException, EmailNotSentException;

    /**
     * Second step in the process for a user to reset their password. The user's password is replaced with a new
     * password if the correct token is sent with the new password.
     * @param request The request encapsulated as an {@link CompletePasswordResetRequest} object.
     * @return Returns the result in an encapsulated {@link CompletePasswordResetResponse} object.
     * @throws NotAuthorizedException Thrown when the reset key has expired or the presented token is invalid.
     * @since 1.0.0
     */
    CompletePasswordResetResponse completePasswordReset(CompletePasswordResetRequest request)
            throws NotAuthorizedException;

    /**
     * Used to create a user with a user selected password and role of a normal user. This is used for registration on
     * the front end of the API.
     * @param request The request encapsulated as an {@link CreateUnmanagedUserRequest} object.
     * @return Returns the result in an encapsulated {@link CreateUnmanagedUserResponse} object.
     * @throws DuplicateUsernameException Thrown when a new user tries to register a username that already exists in the
     *         system.
     * @throws EmailAlreadyExistsException Thrown when  a new user tries to register an email address that already
     *         exists in the system.
     * @throws EmailNotSentException Thrown when the reset key has expired or the presented token is invalid.
     * @since 1.0.0
     */
    CreateUnmanagedUserResponse createUnmanagedUser(CreateUnmanagedUserRequest request)
            throws DuplicateUsernameException, EmailAlreadyExistsException, EmailNotSentException;

    /**
     * Used to create a user with a random generated password and roles selected by administrator. If no role is
     * specified, then a default user role is assigned. This is used for user creation in the user management section of
     * the API.
     * @param request The request encapsulated as an {@link CreateManagedUserRequest} object.
     * @return Returns the result in an encapsulated {@link CreateManagedUserResponse} object.
     * @throws DuplicateUsernameException Thrown when a new user tries to register a username that already exists in the
     *         system.
     * @throws EmailAlreadyExistsException Thrown when  a new user tries to register an email address that already
     *         exists in the system.
     * @throws EmailNotSentException Thrown when the reset key has expired or the presented token is invalid.
     * @since 1.0.0
     */
    CreateManagedUserResponse createManagedUser(CreateManagedUserRequest request)
            throws DuplicateUsernameException, EmailAlreadyExistsException, EmailNotSentException;

    /**
     * Update the user's detail who is in the current security context.
     * @param request The request encapsulated as an {@link UpdateUserRequest} object.
     * @return Returns the result in an encapsulated {@link UpdateUserResponse} object.
     * @throws NonExistentException Thrown when the current user in the security context can't be found in the system.
     * @since 1.0.0
     */
    UpdateUserResponse updateUser(UpdateUserRequest request) throws NonExistentException, EmailAlreadyExistsException;

    /**
     * Delete a user in the system.
     * @param request The request encapsulated as an {@link DeleteUserRequest} object.
     * @return Returns the result in an encapsulated {@link DeleteUserResponse} object.
     * @throws NonExistentException Thrown when the username specified for deletion can't be found in the system.
     * @since 1.0.0
     */
    DeleteUserResponse deleteUser(DeleteUserRequest request) throws NonExistentException;

    /**
     * Change the the user's password who is in the current security context.
     * @param request The request encapsulated as an {@link ChangePasswordRequest} object.
     * @return Returns the result in an encapsulated {@link ChangePasswordResponse} object.
     * @throws NonExistentException Thrown when the current user in the security context can't be found in the system.
     * @since 1.0.0
     */
    ChangePasswordResponse changePassword(ChangePasswordRequest request) throws NonExistentException;

    /**
     * Get the roles associated with a specific username.
     * @param request The request encapsulated as an {@link GetUserWithAuthoritiesByLoginRequest} object.
     * @return Returns the result in an encapsulated {@link GetUserWithAuthoritiesByLoginResponse} object.
     * @throws NonExistentException Thrown when the specified username can't be found in the system.
     * @since 1.0.0
     */
    GetUserWithAuthoritiesByLoginResponse getUserWithAuthoritiesByLogin(GetUserWithAuthoritiesByLoginRequest request) throws NonExistentException;

    /**
     * Get the roles associated with the user in the current security context.
     * @param request The request encapsulated as an {@link GetUserWithAuthoritiesRequest} object.
     * @return Returns the result in an encapsulated {@link GetUserWithAuthoritiesResponse} object.
     * @throws NonExistentException Thrown when the current user in the security context can't be found in the system.
     * @since 1.0.0
     */
    GetUserWithAuthoritiesResponse getUserWithAuthorities(GetUserWithAuthoritiesRequest request) throws NonExistentException;
}

}
