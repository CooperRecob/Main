from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from time import sleep

# read the username and password from the text file
file = open("schedule.txt", "r")
email = file.readline().rstrip()
password = file.readline().rstrip()
file.close()

# inputs the username, password, and classes to be scheduled into the FlexiSCHED website
driver = webdriver.Chrome()

driver.get("https://accounts.google.com/o/oauth2/auth/oauthchooseaccount?response_type=code&redirect_uri=https%3A%2F%2Ffortschools.flexisched.net%2FgoogleLogin.php&client_id=418948195496-fvrrvu52kn6rlcvhvn5td7t48i784vmm.apps.googleusercontent.com&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&access_type=online&approval_prompt=auto&flowName=GeneralOAuthFlow")

email_input = driver.find_element(By.XPATH, "//input[@id='identifierId']")
email_input.send_keys(email + Keys.RETURN)
sleep(2)
password_input = driver.find_element(By.XPATH, "//input[@name='password']")
password_input.send_keys(password + Keys.RETURN)

sleep(5)
driver.quit()