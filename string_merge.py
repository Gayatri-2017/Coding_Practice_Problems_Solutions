'''
Write an immutable function that merges the following inputs into a single list.
Inputs
- Original list of strings
- List of strings to be added
- List of strings to be removed
Return
- List shall only contain unique values
- List shall be ordered as follows
--- Most character count to least character count
--- In the event of a tie, reverse alphabetical
'''

def string_merge(orig_list, add_list, remove_list):
	
	orig_list = list((set(orig_list)|set(add_list))-set(remove_list))

	orig_list.sort(reverse=True)
	orig_list.sort(key=len, reverse=True)

	return orig_list

# Driver code
orig_list = ['one', 'two', 'three',]
add_list = ['one', 'two', 'five', 'six']
remove_list = ['two', 'five']

print("Result List = \n", string_merge(orig_list, add_list, remove_list))
