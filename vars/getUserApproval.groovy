def Boolean call(String promptid,String prompt_text,
                 String  inquiry_text ) {
  try {
    Boolean retval = input( id: promptid,
      message: prompt_text,
      [ $class: 'BooleanParameterDefinition',
        defaultValue: false,
        description: inquiry_text
      ]
      )
   } catch(err) {
      retval = false 
   }

   return retval
}


    
  