"""ocr fruit sale"""
import PyPDF2

pdfFileObj = open('com/fruitSale/cropped bigsheet.pdf', 'rb')
pdfReader = PyPDF2.PdfReader(pdfFileObj)

print(len(pdfReader.pages))
for i, pageObj in enumerate(pdfReader.pages):
    textFile = open("com/fruitSale/cropped bigsheet.txt", "a", encoding="utf-8")
    textFile.write(pageObj.extract_text())

pdfFileObj.close()
textFile.close()
