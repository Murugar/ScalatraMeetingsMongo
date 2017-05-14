function convertUrl(href){
    var baseUrl = window.location.origin
    var url = baseUrl + href
    window.location.href = url
}