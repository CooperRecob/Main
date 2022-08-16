from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from time import sleep

driver = webdriver.Chrome()

driver.get("https://accounts.google.com/o/oauth2/auth/oauthchooseaccount?response_type=code&redirect_uri=https%3A%2F%2Ffortschools.flexisched.net%2FgoogleLogin.php&client_id=418948195496-fvrrvu52kn6rlcvhvn5td7t48i784vmm.apps.googleusercontent.com&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&access_type=online&approval_prompt=auto&flowName=GeneralOAuthFlow")

# send email and password to the google login page
email = "recocoo@fortschools.org"
password = "K12447y1"

email_input = driver.find_element(By.XPATH, "//input[@id='identifierId']")
email_input.send_keys(email + Keys.RETURN)
sleep(2)
password_input = driver.find_element(By.XPATH, "//input[@name='password']")
password_input.send_keys(password + Keys.RETURN)

sleep(5)
driver.quit()