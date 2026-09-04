from fpdf import FPDF

# Sample data for 2A
data_2A = [
    ["Time", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"],
    ["08:00-09:00", "MATH0541111", "CSE0613121", "", "", ""],
    ["09:00-10:00", "", "GED0222121", "", "CHEM0531175", ""],
    ["10:00-11:00", "PHY0533111", "", "", "", "CSE0613122"],
    # Add more rows as needed
]

pdf = FPDF()
pdf.add_page()
pdf.set_font("Arial", size=10)

# Table settings
col_width = pdf.w / len(data_2A[0]) - 10
row_height = 10

for row in data_2A:
    for item in row:
        pdf.cell(col_width, row_height, txt=item, border=1, align="C")
    pdf.ln(row_height)

pdf.output("routine_2A.pdf")
print("PDF created: routine_2A.pdf")