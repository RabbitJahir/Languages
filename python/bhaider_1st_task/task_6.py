is_student = False
has_id = False

print("Can enter exam hall") if (is_student and has_id) else print("Can not enter exam hall")

print("Gets access to library") if (is_student or has_id) else print("Gets access to library")

print("Turned your student True") if not is_student else print("Turned your student false") 

print(is_student^has_id)