// 매개변수 value가 null이나 빈 문자열이거나, 정의되지 않았거나 null이 아닌 객체의 키값의 크기가 없는 경우
// 자료형의 상관없이 값이 비어있는지 확인...

/**
 * 자료형에 상관없이 값이 비었는지 확인..
 * @param value
 * @returns {boolean}
 */
function isEmpty(value) {
    if (value == null || value == "" || value == undefined || (value != null && typeof value == "object" && !Object.keys(value).lengh)) {
        return true;
    }
    return false;
}


/**
 *
 * @param str
 * @returns {number}
 */
function charToUnicode(str) {
    return (str.charCodeAt(str.length - 1) - 0xAc00) % 28;
}

/**
 * 필드 1, 필드 2의 값이 다르면 해당 필드2로 focus한 뒤에 메시지 출력
 * @param field1 - 타겟 필드1
 * @param field2 - 타겟 필드2
 * @param fieldName - 필드 이름
 * @returns {boolean}
 */
function equals(field1, field2, fieldName) {
    if (field1.value === field2.value) {
        return true;
    } else {
        var message = "";

        if (charToUnicode(fieldName) > 0) {
            message = fieldName + "이 일치하지 않습니다.";
        } else {
            message = fieldName + "가 일치하지 않습니다.";
        }
        field2.focus();
        alert(message);
        return false;
    }
}

/**
 * field의 값이 올바른 형식인지 체크 (정규표현식 사용)
 * @param field
 * @param fieldName
 * @param focusField
 * @returns {boolean}
 */
function isValid(field, fieldName, focusField) {
    if (isEmpty(field.value) == true) {
        var message = (charToUnicode(fieldName) > 0) ? fieldName + "을 확인해주세요." : fieldName + "를 확인해주세요.";
        field.focus();
        alert(message);
        return false;
    }
    return true;
}

/**
 * 둘 중 비어있지 않은 값을 반환
 * @param value1
 * @param value2
 * @returns {*}
 */
function nvl(value1, value2) {
    return (isEmpty(value1) == false ? value1 : value2);
}
