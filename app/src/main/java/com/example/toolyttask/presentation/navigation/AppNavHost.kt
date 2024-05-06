package com.example.toolyttask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.toolyttask.presentation.LoginViewModel
import com.example.toolyttask.presentation.screens.Landing
import com.example.toolyttask.presentation.screens.Login
import com.example.toolyttask.presentation.screens.Profile
import com.example.toolyttask.presentation.screens.Started


@Composable
fun AppNavHost(
    loginViewModel: LoginViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Login.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Landing.route) {
            Landing(navController)
        }

        composable(NavigationItem.Started.route) {
            Started(navController)
        }

        composable(NavigationItem.Login.route) {
            Login(
                navController,
                getPhoneNumber = {
                    return@Login loginViewModel.phoneNumber
                },
                updatePhoneNumber = {
                    loginViewModel.updatePhoneNumber(it)
                }
            )
        }

        composable(NavigationItem.Profile.route) {
            Profile(
                navController,
                getFirstName = {
                    return@Profile loginViewModel.firstName
                },
                updateFirstName = {
                    loginViewModel.updateFirstName(it)
                },
                getLastName = {
                    return@Profile loginViewModel.lastName
                },
                updateLastName = {
                    loginViewModel.updateLastName(it)
                },
                getPhoneNumber = {
                    return@Profile loginViewModel.phoneNumber
                },
                updatePhoneNumber = {
                    loginViewModel.updatePhoneNumber(it)
                },
                getPostCode = {
                    return@Profile loginViewModel.postCode
                },
                updatePostCode = {
                    loginViewModel.updatePostCode(it)
                },
                submitForm = {
                    loginViewModel.sendLoginDetails()
                }
            )
        }
    }

}

