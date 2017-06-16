;(function(){
    var small = "(a|an|and|as|at|but|by|en|for|if|in|of|on|or|the|to|v[.]?|via|vs[.]?)";
    var punct = "([!\"#$%&'()*+,./:;<=>?@[\\\\\\]^_`{|}~-]*)";
  
    this.titleCaps = function(title){
        var parts = [], split = /[:.;?!] |(?: |^)["Ò]/g, index = 0;
        
        while (true) {
            var m = split.exec(title);

            parts.push( title.substring(index, m ? m.index : title.length)
                .replace(/\b([A-Za-z][a-z.'Õ]*)\b/g, function(all){
                    return /[A-Za-z]\.[A-Za-z]/.test(all) ? all : upper(all);
                })
                .replace(RegExp("\\b" + small + "\\b", "ig"), lower)
                .replace(RegExp("^" + punct + small + "\\b", "ig"), function(all, punct, word){
                    return punct + upper(word);
                })
                .replace(RegExp("\\b" + small + punct + "$", "ig"), upper));
            
            index = split.lastIndex;
            
            if ( m ) parts.push( m[0] );
            else break;
        };
        
        return parts.join("").replace(/ V(s?)\. /ig, " v$1. ")
            .replace(/(['Õ])S\b/ig, "$1s")
            .replace(/\b(AT&T|Q&A)\b/ig, function(all){
                return all.toUpperCase();
            });
    };
    
    function lower(word){
        return word.toLowerCase();
    };
    
    function upper(word){
      return word.substr(0,1).toUpperCase() + word.substr(1);
    };
})();

jQuery.fn.capitalize = function() {
    $(this[0]).keyup(function(event) {
        var box = event.target;
        var txt = $(this).val();
        var start = box.selectionStart;
        var end = box.selectionEnd;
        $(this).val(txt.replace(/^(.)|(\s|\-)(.)/g, function($1) {
            return $1.toUpperCase();
        }));
        box.setSelectionRange(start, end);
    });

   return this;
};

function ucfirst(str,force){
    str=force ? str.toLowerCase() : str;
    return str.replace(/(\b)([a-zA-Z])/,
    function(firstLetter){
        return   firstLetter.toUpperCase();
    });
};

function ucwords(str,force){
    str=force ? str.toLowerCase() : str;  
    return str.replace(/(\b)([a-zA-Z])/g,
    function(firstLetter){
        return   firstLetter.toUpperCase();
    });
};

function lcwords(str,force){
    str=force ? str.toLowerCase() : str;  
    return str.replace(/(\b)([a-zA-Z])/g,
    function(firstLetter){
        return   firstLetter.toLowerCase();
    });
};