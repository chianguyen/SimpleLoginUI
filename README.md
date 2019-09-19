# SimpleLoginUI
Simple Login UI with Android Studio in Kotlin

> It includes 3 Activities:

1. Login Activity: 
  + Gradient background
  + username input 
  + password input 
  + LOGIN button:
    - Check for current default (username, password) = ("chi", "123")
    - Text to Speech to annouce:
       = Incorrect credentials 
       = Correct credentials 

  + REGISTER button to switch to Registration activity
    - Text to Speech to announce: 
       = If the button is pushed

2. Signed-In Activity:
  + Gradient background
  + Greeting message
  + Confirm message include username and password
  + LOGOUT button: go back to Login Activity
    - Text to Speech to announce logout action.

3. Registration Activity:
  + username input 
  + password input 
  + confirm password input 
  + REGISTER button:
    - Check if the input are blank
    - Check if the password and confirm password text are the same
    - If true for all, go back to Login Activity
    - Text to Speech to announce: 
      = If input fields are invalid
      = If all true, and go back to Login Activity
